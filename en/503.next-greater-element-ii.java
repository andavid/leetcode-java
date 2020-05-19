/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (50.85%)
 * Likes:    734
 * Dislikes: 46
 * Total Accepted:    54.1K
 * Total Submissions: 104.9K
 * Testcase Example:  '[1,2,1]'
 *
 *
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find
 * next greater number; The second 1's next greater number needs to search
 * circularly, which is also 2.
 *
 *
 *
 * Note:
 * The length of given array won't exceed 10000.
 *
 */
class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.empty() && stack.peek() <= nums[i % n]) {
        stack.pop();
      }
      result[i % n] = stack.empty() ? -1 : stack.peek();
      stack.push(nums[i % n]);
    }

    return result;
  }
}

