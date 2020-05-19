/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (49.20%)
 * Total Accepted:    253.6K
 * Total Submissions: 510.2K
 * Testcase Example:  '"leetcode"'
 *
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 *
 *
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */
class Solution {
  public int firstUniqChar(String s) {
    int len = s.length();
    int[] count = new int[26];
    for (int i = 0; i < len; i++) {
      count[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < len; i++) {
      if (count[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}

