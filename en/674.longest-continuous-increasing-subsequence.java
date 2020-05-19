/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 *
 * algorithms
 * Easy (44.71%)
 * Likes:    493
 * Dislikes: 101
 * Total Accepted:    76.6K
 * Total Submissions: 171K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 *
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray).
 *
 *
 * Example 1:
 *
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its
 * length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a
 * continuous one where 5 and 7 are separated by 4.
 *
 *
 *
 * Example 2:
 *
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its
 * length is 1.
 *
 *
 *
 * Note:
 * Length of the array will not exceed 10,000.
 *
 */
class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 1;
    int left = 0;
    int right = 1;

    while (right < nums.length) {
      if (nums[right -1] < nums[right]) {
        max = Math.max(max, right - left + 1);
      } else {
        left = right;
      }
      right++;
    }

    return max;
  }
}

