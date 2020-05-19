/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class Solution {
  public int totalNQueens(int n) {
    int[] result = new int[n];
    return total(result, n, 0);
  }

  public int total(int[] result, int n, int row) {
    if (row == n) {
      return 1;
    }

    int count = 0;
    for (int column = 0; column < n; column++) {
      if (isOk(result, n, row, column)) {
        result[row] = column;
        count += total(result, n, row + 1);
      }
    }

    return count;
  }

  public boolean isOk(int[] result, int n, int row, int column) {
    int leftup = column - 1;
    int rightup = column + 1;
    for (int i = row - 1; i >= 0; i--) {
      if (result[i] == column) return false;
      if (leftup >= 0) {
        if (result[i] == leftup) return false;
      }
      if (rightup < n) {
        if (result[i] == rightup) return false;
      }
      leftup--;
      rightup++;
    }
    return true;
  }

}

