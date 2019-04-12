/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.70%)
 * Total Accepted:    373K
 * Total Submissions: 910.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int len = digits.length;

    for (int i = len - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
      if (carry == 0) {
        break;
      }
    }

    if (carry > 0) {
      int[] result = new int[len + 1];
      result[0] = 1;
      return result;
    } else {
      return digits;
    }
  }
}

