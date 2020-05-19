/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (30.41%)
 * Likes:    1646
 * Dislikes: 74
 * Total Accepted:    79.4K
 * Total Submissions: 260.7K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 *
 *
 *
 * Note:
 *
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means .
 *
 *
 */
class Solution {
  public int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    int start = -1, end = -2, n = nums.length;
    int max = nums[0];
    int min = nums[n - 1];

    for (int i = 1; i < n; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[n - 1 - i]);

      // end 索引后面的都是有序的
      if (nums[i] < max) {
        end = i;
      }

      // start 索引前面的都是有序的
      if (nums[n - 1 - i] > min) {
        start = n - 1 - i;
      }
    }

    return end - start + 1;
  }
}

