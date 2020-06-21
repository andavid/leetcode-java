/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (50.12%)
 * Likes:    372
 * Dislikes: 0
 * Total Accepted:    46.4K
 * Total Submissions: 87.9K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 *
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 *
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 *
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 *
 */

// @lc code=start
class Solution {

  int index = 0;

  public String decodeString(String s) {
    int len = s.length();
    int num = 0;
    StringBuilder sb = new StringBuilder();

    while (index < len) {
      char ch = s.charAt(index++);
      if ('0' <= ch && ch <= '9') {
        num = num * 10 + (ch - '0');
      } else if (ch == '[') {
        String temp = decodeString(s);
        for (int j = 0; j < num; j++) {
          sb.append(temp);
        }
        num = 0;
      } else if (ch == ']') {
        return sb.toString();
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
// @lc code=end

