/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (50.82%)
 * Likes:    835
 * Dislikes: 1538
 * Total Accepted:    146.2K
 * Total Submissions: 287.8K
 * Testcase Example:  '1\n2'
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use
 * the operator + and -.
 *
 *
 * Example 1:
 *
 *
 * Input: a = 1, b = 2
 * Output: 3
 *
 *
 *
 * Example 2:
 *
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 *
 *
 *
 */
class Solution {
  public int getSum(int a, int b) {
    int sum = a ^ b;
    int carry = (a & b) << 1;

    while (carry != 0) {
      int temp = sum;
      sum = sum ^ carry;
      carry = (temp & carry) << 1;
    }

    return sum;
  }
}

