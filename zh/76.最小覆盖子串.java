/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (37.77%)
 * Likes:    636
 * Dislikes: 0
 * Total Accepted:    61.7K
 * Total Submissions: 161.6K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 *
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 */

// @lc code=start
class Solution {
  public String minWindow(String s, String t) {
    int[] need = new int[128];
    int[] window = new int[128];
    for (char ch : t.toCharArray()) {
      need[ch]++;
    }

    int left = 0, right = 0;
    int count = 0;
    int start = 0, len = s.length() + 1;

    while (right < s.length()) {
      char ch = s.charAt(right);
      right++;
      if (need[ch] > 0) {
        window[ch]++;
        if (window[ch] <= need[ch]) {
          count++;
        }
      }

      while (count == t.length()) {
        if (right - left < len) {
          start = left;
          len = right - left;
        }

        ch = s.charAt(left);
        left++;
        if (need[ch] > 0) {
          if (window[ch] <= need[ch]) {
            count--;
          }
          window[ch]--;
        }
      }
    }

    return (len > s.length()) ? "" : s.substring(start, start + len);
  }
}
// @lc code=end

