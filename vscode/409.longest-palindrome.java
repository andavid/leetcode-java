/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (47.46%)
 * Total Accepted:    91.6K
 * Total Submissions: 192.3K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * 
 * Example: 
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 */
class Solution {
  public int longestPalindrome(String s) {
    int[] counts = new int[256];
    for (char c : s.toCharArray()) {
      counts[c]++;
    }
    int palindrome = 0;
    for (int count : counts) {
      palindrome += (count/2) * 2;
    }
    if (palindrome < s.length()) {
      palindrome++;
    }
    return palindrome;
  }
}

