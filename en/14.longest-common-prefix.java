/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.01%)
 * Total Accepted:    428.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 */
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    return lcp(strs, 0, strs.length - 1);
  }

  public String lcp(String[] strs, int i, int j) {
    if (i == j) {
      return strs[i];
    }

    int mid = (i + j) / 2;
    return commonPrefix(lcp(strs, i, mid), lcp(strs, mid+1, j));
  }

  public String commonPrefix(String a, String b) {
    int min = Math.min(a.length(), b.length());
    int i = 0;
    while (i < min && a.charAt(i) == b.charAt(i)) {
      i++;
    }
    return a.substring(0, i);
  }
}

