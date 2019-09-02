/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.76%)
 * Likes:    2179
 * Dislikes: 213
 * Total Accepted:    287.2K
 * Total Submissions: 888.2K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 *
 */
class Solution {
  public boolean canJump(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 0) {
        dp[i] = i;
      } else if (i + nums[i] >= nums.length - 1) {
        dp[i] = nums.length - 1;
      } else {
        int max = 0;
        for (int j = i + 1; j <= i + nums[i]; j++) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
        dp[i] = max;
      }
    }

    if (dp[0] == nums.length - 1) {
      return true;
    }
    return false;
  }
}

