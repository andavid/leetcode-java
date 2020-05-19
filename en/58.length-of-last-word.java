/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.24%)
 * Likes:    408
 * Dislikes: 1708
 * Total Accepted:    285.4K
 * Total Submissions: 884.1K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * Example:
 *
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 *
 *
 */
class Solution {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int last = s.length() - 1;
    while (last >= 0 && s.charAt(last) == ' ') {
      last--;
    }

    int length = 0;
    while (last >= 0 && s.charAt(last) != ' ') {
      last--;
      length++;
    }

    return length;
  }
}

