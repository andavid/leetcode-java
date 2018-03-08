import java.util.*;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    final int size = 9;

    if (board == null || board.length != size || board[0].length != size) {
      return false;
    }

    ArrayList<HashSet<Character>> row = new ArrayList<HashSet<Character>>();
    ArrayList<HashSet<Character>> col = new ArrayList<HashSet<Character>>();
    ArrayList<HashSet<Character>> area = new ArrayList<HashSet<Character>>();

    for (int i = 0; i < size; i++) {
      row.add(new HashSet<Character>());
      col.add(new HashSet<Character>());
      area.add(new HashSet<Character>());
    }

    for (int i = 0; i < size; i++) { // row
      for (int j = 0; j < size; j++) { // column
        int box = 3 * (i / 3) + j / 3; // sub box
        if (board[i][j] != '.') {
          if (row.get(i).contains(board[i][j])
              || col.get(j).contains(board[i][j])
              || area.get(box).contains(board[i][j])) {
            return false;
          }
          row.get(i).add(board[i][j]);
          col.get(j).add(board[i][j]);
          area.get(box).add(board[i][j]);
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
