/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.63%)
 * Total Accepted:    505.9K
 * Total Submissions: 1.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
  private int start = 0;
  private int maxLen = 0;

  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }

    for (int i = 0; i < len - 1; i++) {
      extend(s, i, i);
      extend(s, i, i+1);
    }

    return s.substring(start, start + maxLen);
  }

  public void extend(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }
    if (maxLen < k - j - 1) {
      maxLen = k - j - 1;
      start = j + 1;
    }
  }
}

