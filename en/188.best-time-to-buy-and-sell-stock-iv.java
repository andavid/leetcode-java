/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (25.90%)
 * Total Accepted:    80.3K
 * Total Submissions: 309.9K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 *
 * Example 1:
 *
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 =
 * 3.
 *
 */
class Solution {
  public int maxProfit(int k, int[] prices) {
    int profit = 0;
    int n = prices.length;

    // 当 k 大于天数的一半时，基本可以等同于交易任意次
    if (k >= n/2) {
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i-1]) {
          profit += prices[i] - prices[i-1];
        }
      }
      return profit;
    }

    int dp[][] = new int[k+1][n];
    for (int i = 1; i <= k; i++) {
      int temp = -prices[0];
      for (int j = 1; j < n; j++) {
        // 交易 i 次，第 j 天的最大收益
        dp[i][j] = Math.max(dp[i][j-1], temp + prices[j]);
        // 交易 i 次，第 j 天买入股票时的最大收益
        temp = Math.max(temp, dp[i-1][j-1] - prices[j]);
      }
    }

    return dp[k][n-1];
  }
}

