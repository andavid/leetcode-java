/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (17.57%)
 * Likes:    644
 * Dislikes: 2410
 * Total Accepted:    309K
 * Total Submissions: 1.7M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 *
 * Example 2:
 *
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 *
 *
 * Example 3:
 *
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 *
 *
 *
 *
 * Note:
 *
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 *
 *
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
class Solution {
  public String reverseWords(String s) {
    String str = reverse(s.trim());
    StringBuilder sb = new StringBuilder();

    int start = 0;
    int end = str.indexOf(" ");

    while (start < str.length() && end != -1) {
      sb.append(reverse(str.substring(start, end)));
      sb.append(" ");
      start = end + 1;
      while (start < str.length() && str.charAt(start) == ' ') {
        start++;
      }
      end = str.indexOf(" ", start);
    }

    if (start < str.length()) {
      sb.append(reverse(str.substring(start)));
    }

    return sb.toString();
  }

  public String reverse(String str) {
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }
}

