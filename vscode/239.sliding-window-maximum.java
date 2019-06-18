/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0) {
      return new int[0];
    }

    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    int i = 0;
    for (; i < k; i++) {
      queue.offer(nums[i]);
    }

    int[] result = new int[nums.length - k + 1];
    int index = 0;
    result[index++] = queue.peek();

    while (i < nums.length) {
      queue.remove(nums[i - k]);
      queue.offer(nums[i]);
      result[index++] = queue.peek();
      i++;
    }

    return result;
  }
}

