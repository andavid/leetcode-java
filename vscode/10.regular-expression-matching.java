/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.20%)
 * Likes:    2822
 * Dislikes: 543
 * Total Accepted:    321.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 *
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 *
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Example 4:
 *
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 *
 *
 * Example 5:
 *
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 *
 */
class Solution {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    return matchInternal(s, 0, p, 0);
  }

  public boolean matchInternal(String str, int strIndex, String pattern, int patternIndex) {
    int strLength = str.length();
    int patternLength = pattern.length();

    // 如果匹配串和模式串都匹配结束
    if (patternIndex == patternLength) {
      return (strIndex == strLength);
    }

    // 如果匹配串匹配结束，模式串没有匹配结束，判断模式串第二个字符是不是 *
    if (strIndex == strLength) {
      if (patternIndex+1 < patternLength && pattern.charAt(patternIndex + 1) == '*') {
        return matchInternal(str, strIndex, pattern, patternIndex + 2); // * 匹配 0 次
      } else {
        return false;
      }
    }

    // 匹配串和模式串都没有匹配结束，区分模式串的第二个字符是不是*
    if (patternIndex == patternLength-1 || pattern.charAt(patternIndex + 1) != '*') {
      // 模式串只剩下一个字符，或者模式串的第二个字符不是*
      if (matchOne(str, strIndex, pattern, patternIndex)) {
        // 当前字符匹配成功，继续匹配下一个字符
        return matchInternal(str, strIndex + 1, pattern, patternIndex + 1);
      } else {
        return false;
      }
    } else {
      // 模式串的第二个字符是*
      if (matchOne(str, strIndex, pattern, patternIndex)) {
        return matchInternal(str, strIndex, pattern, patternIndex + 2) // * 匹配 0 次
            || matchInternal(str, strIndex + 1, pattern, patternIndex + 2) // * 匹配 1 次
            || matchInternal(str, strIndex + 1, pattern, patternIndex); // * 匹配 N 次
      } else {
        return matchInternal(str, strIndex, pattern, patternIndex + 2); // * 匹配 0 次
      }
    }
  }

  public boolean matchOne(String str, int strIndex, String pattern, int patternIndex) {
    return pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex);
  }
}

