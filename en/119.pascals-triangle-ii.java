/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (42.10%)
 * Total Accepted:    195.6K
 * Total Submissions: 455.8K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 *
 * Input: 3
 * Output: [1,3,3,1]
 *
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */
class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) return result;
    result.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = i - 1; j > 0; j--) {
        result.set(j, result.get(j) + result.get(j-1));
      }
      result.add(1);
    }
    return result;
  }
}

