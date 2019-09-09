/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (57.70%)
 * Likes:    1608
 * Dislikes: 82
 * Total Accepted:    116.8K
 * Total Submissions: 202K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 *
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 *
 * Example 1:
 *
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 *
 * Note:
 *
 *
 * The input string length won't exceed 1000.
 *
 *
 *
 *
 */
class Solution {
  public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += palindromic(s, i, i);
      count += palindromic(s, i, i + 1);
    }
    return count;
  }

  public int palindromic(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length()
      && (s.charAt(left) == s.charAt(right))) {
      left--;
      right++;
      count++;
    }
    return count;
  }
}

