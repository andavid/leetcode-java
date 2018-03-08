import java.util.*;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9) {
      return false;
    }

    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxs = new boolean[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int k = (i / 3) * 3 + j / 3;
          int number = board[i][j] - '0' - 1;
          if (rows[i][number] || cols[j][number] || boxs[k][number]) {
            return false;
          }
          rows[i][number] = cols[j][number] = boxs[k][number] = true;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    char[][] board = {
      {'.','8','7','6','5','4','3','2','1'},
      {'2','.','.','.','.','.','.','.','.'},
      {'3','.','.','.','.','.','.','.','.'},
      {'4','.','.','.','.','.','.','.','.'},
      {'5','.','.','.','.','.','.','.','.'},
      {'6','.','.','.','.','.','.','.','.'},
      {'7','.','.','.','.','.','.','.','.'},
      {'8','.','.','.','.','.','.','.','.'},
      {'9','.','.','.','.','.','.','.','.'}
    };

    System.out.println(solution.isValidSudoku(board));
  }
}
