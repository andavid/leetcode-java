/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (19.83%)
 * Likes:    525
 * Dislikes: 1165
 * Total Accepted:    94.3K
 * Total Submissions: 474.4K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 *
 * Example 1:
 *
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 *
 *
 * Example 2:
 *
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 *
 * Example 3:
 *
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 *
 */
class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();

    boolean sign = (numerator > 0) == (denominator > 0);
    if (!sign) {
      sb.append("-");
    }

    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    sb.append(num / den);
    num %= den;
    if (num == 0) {
      return sb.toString();
    }

    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    map.put(num, sb.length());

    while (num != 0) {
      num *= 10;
      sb.append(num / den);
      num %= den;
      if (map.containsKey(num)) {
        sb.insert(map.get(num), "(");
        sb.append(")");
        break;
      } else {
        map.put(num, sb.length());
      }
    }

    return sb.toString();
  }
}

