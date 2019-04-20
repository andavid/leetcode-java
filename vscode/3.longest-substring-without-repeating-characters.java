/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (27.96%)
 * Total Accepted:    849.6K
 * Total Submissions: 3M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 *
 *
 *
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int len = s.length();
    if (len < 2) {
      return len;
    }

    int max = 0;
    Set<Character> set = new HashSet<>();

    for (int fast = 0, slow = 0; fast < len; fast++) {
      while (set.contains(s.charAt(fast))) {
        set.remove(s.charAt(slow));
        slow++;
      }
      set.add(s.charAt(fast));
      max = Math.max(max, fast - slow + 1);
    }

    return max;
  }
}

