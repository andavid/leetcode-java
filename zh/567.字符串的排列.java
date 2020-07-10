/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 *
 * https://leetcode-cn.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (35.79%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    33.3K
 * Total Submissions: 91.4K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 *
 * 示例2:
 *
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 *
 *
 * 注意：
 *
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 *
 */

// @lc code=start
class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int[] need = new int[128];
    int[] window = new int[128];
    for (char ch : s1.toCharArray()) {
      need[ch]++;
    }

    int left = 0, right = 0;
    int count = 0;

    while (right < s2.length()) {
      char ch = s2.charAt(right);
      right++;
      if (need[ch] > 0) {
        window[ch]++;
        if (window[ch] <= need[ch]) {
          count++;
        }
      }

      while (right - left >= s1.length()) {
        if (count == s1.length()) {
          return true;
        }

        ch = s2.charAt(left);
        left++;
        if (need[ch] > 0) {
          if (window[ch] <= need[ch]) {
            count--;
          }
          window[ch]--;
        }
      }
    }

    return false;
  }
}
// @lc code=end

