/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (36.47%)
 * Total Accepted:    167K
 * Total Submissions: 449.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 *
 * Example 2:
 *
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 */
class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if (m == 0) return n;
    if (n == 0) return m;
    if (m == 1) return n - (word2.startsWith(word1) ? 1 : 0);
    if (n == 1) return m - (word1.startsWith(word2) ? 1 : 0);
    if (word1.startsWith(word2)) return m - n;
    if (word2.startsWith(word1)) return n - m;

    int[][] dp = new int[m+1][n+1];

    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i <= n; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
        }
      }
    }

    return dp[m][n];
  }
}

