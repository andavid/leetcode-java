/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (43.88%)
 * Likes:    1535
 * Dislikes: 85
 * Total Accepted:    108.4K
 * Total Submissions: 239.9K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 *
 *
 *
 */
class Solution {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    Stack<Integer> countStack = new Stack<>();
    Stack<String> strStack = new Stack<>();

    String res = "";
    int count = 0;

    for (char ch : s.toCharArray()) {
      if ('0' <= ch && ch <= '9') {
        count = count * 10 + ch - '0';
      } else if (ch == '[') {
        countStack.push(count);
        strStack.push(res);
        count = 0;
        res = "";
      } else if (ch == ']') {
        StringBuilder sb = new StringBuilder(strStack.pop());
        for (int i = countStack.pop(); i > 0; i--) {
          sb.append(res);
        }
        res = sb.toString();
      } else {
        res += ch;
      }
    }

    return res;
  }
}

