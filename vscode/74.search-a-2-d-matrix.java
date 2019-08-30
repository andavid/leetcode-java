/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.15%)
 * Likes:    975
 * Dislikes: 116
 * Total Accepted:    243.3K
 * Total Submissions: 692.3K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 */
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row = searchLastLess(matrix, target);
    if (row == -1) {
      return false;
    }

    return search(matrix, row, target);
  }

  public boolean search(int[][] matrix, int row, int target) {
    int low = 0;
    int high = matrix[row].length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return false;
  }

  public int searchLastLess(int[][] matrix, int target) {
    int low = 0;
    int high = matrix.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[mid][0] > target) {
        high = mid - 1;
      } else {
        if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }

    return -1;
  }
}

