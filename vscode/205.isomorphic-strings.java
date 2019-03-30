/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (36.73%)
 * Total Accepted:    192.5K
 * Total Submissions: 521.5K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
class Solution {
  public boolean isIsomorphic(String s, String t) {
    int[] indexS = new int[256];
    int[] indexT = new int[256];
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char chs = s.charAt(i);
      char cht = t.charAt(i);
      if (indexS[chs] != indexT[cht]) {
        return false;
      }
      indexS[chs] = i + 1;
      indexT[cht] = i + 1;
    }
    return true;
  }
}

