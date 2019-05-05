/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {
  public List<List<String>> solveNQueens(int n) {
    int[] result = new int[n];
    List<List<String>> list = new ArrayList<>();
    solve(list, result, 0);
    return list;
  }

  public void solve(List<List<String>> list, int[] result, int row) {
    if (row == result.length) {
      list.add(construct(result));
      return;
    }

    for (int column = 0; column < result.length; column++) {
      if (isOk(result, row, column)) {
        result[row] = column;
        solve(list, result, row + 1);
      }
    }
  }

  public boolean isOk(int[] result, int row, int column) {
    int n = result.length;
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

  public List<String> construct(int[] result) {
    List<String> list = new ArrayList<>();
    int n = result.length;
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (result[i] == j) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      list.add(sb.toString());
    }
    return list;
  }

}

