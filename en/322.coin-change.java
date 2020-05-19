/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (31.53%)
 * Likes:    2135
 * Dislikes: 85
 * Total Accepted:    233.5K
 * Total Submissions: 738.6K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount < 1) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    int sum = 0;

    while (++sum <= amount) {
      int min = -1;
      for (int coin : coins) {
        if (sum >= coin && dp[sum - coin] != -1) {
          int temp = dp[sum - coin] + 1;
          if (min < 0 || temp < min) {
            min = temp;
          }
        }
      }
      dp[sum] = min;
    }

    return dp[amount];
  }
}

