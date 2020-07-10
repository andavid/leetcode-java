/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (34.57%)
 * Likes:    3948
 * Dislikes: 0
 * Total Accepted:    559.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */

// @lc code=start
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int[] window = new int[128];
    int left = 0, right = 0;
    int max = 0;

    while (right < s.length()) {
      char ch = s.charAt(right);
      right++;
      window[ch]++;

      while (window[ch] > 1) {
        char c = s.charAt(left);
        left++;
        window[c]--;
      }

      if (right - left > max) {
        max = right - left;
      }
    }

    return max;
  }
}
// @lc code=end

