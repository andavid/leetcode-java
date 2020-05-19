/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.27%)
 * Likes:    2374
 * Dislikes: 316
 * Total Accepted:    416.9K
 * Total Submissions: 985.8K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 *
 */
class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    if (digits.length() == 0) {
      return list;
    }

    for (String preffix : getList(digits.charAt(0) - '0')) {
      List<String> suffixList = letterCombinations(digits.substring(1));
      if (suffixList.size() == 0) {
        list.add(preffix);
      } else {
        for (String suffix : suffixList) {
          list.add(preffix + suffix);
        }
      }
    }

    return list;
  }

  public List<String> getList(int digit) {
    String digitLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();
    for (int i = 0; i < digitLetter[digit].length(); i++) {
      list.add(String.valueOf(digitLetter[digit].charAt(i)));
    }
    return list;
  }
}

