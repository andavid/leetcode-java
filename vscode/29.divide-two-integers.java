/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.16%)
 * Likes:    752
 * Dislikes: 3643
 * Total Accepted:    212.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 *
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 *
 *
 */
class Solution {
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    boolean sign = (dividend < 0) == (divisor < 0);

    // turn dividend and divisor to negative value
    if (dividend > 0) {
      dividend = -dividend;
    }
    if (divisor > 0) {
      divisor = -divisor;
    }

    int result = divideHelper(dividend, divisor);
    if (sign) {
      return result;
    } else {
      return -result;
    }
  }

  public int divideHelper(int dividend, int divisor) {
    if (divisor < dividend) {
      return 0;
    }

    int sum = divisor;
    int multiple = 1;
    while (Integer.MIN_VALUE - sum < sum && sum + sum > dividend) {
      sum += sum;
      multiple += multiple;
    }

    return multiple + divideHelper(dividend - sum, divisor);
  }
}

