/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (38.98%)
 * Likes:    761
 * Dislikes: 42
 * Total Accepted:    57.9K
 * Total Submissions: 147.8K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 *
 * Example 2:
 *
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 *
 *
 * Note:
 *
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 *
 *
 */
class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 > len2) {
      return false;
    }

    int[] count = new int[26];
    for (int i = 0; i < len1; i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }

    if (isAllZeros(count)) {
      return true;
    }

    for (int i = len1; i < len2; i++) {
      count[s2.charAt(i) - 'a']--;
      count[s2.charAt(i - len1) - 'a']++;
      if (isAllZeros(count)) {
        return true;
      }
    }

    return false;
  }

  public boolean isAllZeros(int[] count) {
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }
}

