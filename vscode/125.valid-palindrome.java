/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.24%)
 * Total Accepted:    336.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * Example 1:
 *
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "race a car"
 * Output: false
 *
 *
 */
class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (!isLetterOrDigit(s.charAt(left))) {
        left++;
      } else if (!isLetterOrDigit(s.charAt(right))) {
        right--;
      } else {
        if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
          left++;
          right--;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isLetterOrDigit(char ch) {
    if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || '0' <= ch && ch <= '9') {
      return true;
    }
    return false;
  }

}

