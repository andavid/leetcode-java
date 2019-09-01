/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (40.62%)
 * Likes:    1243
 * Dislikes: 219
 * Total Accepted:    231.3K
 * Total Submissions: 568.7K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 *
 * Follow up:
 *
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 *
 *
 */
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean isFirstCol = false;
    int row = matrix.length;
    int col = matrix[0].length;

    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == 0) {
        isFirstCol = true;
      }

      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (matrix[0][0] == 0) {
      for (int j = 0; j < col; j++) {
        matrix[0][j] = 0;
      }
    }

    if (isFirstCol) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

