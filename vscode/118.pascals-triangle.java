/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (44.60%)
 * Total Accepted:    242.2K
 * Total Submissions: 534K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 *
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows <= 0) return result;

    List<Integer> pre = new ArrayList<>();
    pre.add(1);
    result.add(pre);

    for (int i = 2; i <= numRows; i++) {
      List<Integer> cur = new ArrayList<>();
      cur.add(1);
      for (int j = 1; j < i - 1; j++) {
        cur.add(pre.get(j-1) + pre.get(j));
      }
      cur.add(1);
      result.add(cur);
      pre = cur;
    }

    return result;
  }
}

