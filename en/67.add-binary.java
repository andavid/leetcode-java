/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.82%)
 * Likes:    1075
 * Dislikes: 202
 * Total Accepted:    323.3K
 * Total Submissions: 808.9K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */
class Solution {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    while (i >= 0 || j >= 0) {
      int num1 = (i >= 0) ? a.charAt(i) - '0' : 0;
      int num2 = (j >= 0) ? b.charAt(j) - '0' : 0;
      int sum = num1 + num2 + carry;
      carry = sum / 2;
      sb.append(sum % 2);
      i--;
      j--;
    }

    if (carry != 0) {
      sb.append(1);
    }

    return sb.reverse().toString();
  }
}

