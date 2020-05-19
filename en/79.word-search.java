/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (32.15%)
 * Likes:    2097
 * Dislikes: 107
 * Total Accepted:    317.7K
 * Total Submissions: 988K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 *
 * Example:
 *
 *
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 */
class Solution {
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (exist(board, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean exist(char[][] board, int i, int j, String word, int pos) {
    if (pos == word.length()) return true;
    if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1) return false;
    if (board[i][j] != word.charAt(pos)) return false;
    board[i][j] = '*';
    boolean result = exist(board, i - 1, j, word, pos + 1)
                  || exist(board, i + 1, j, word, pos + 1)
                  || exist(board, i, j - 1, word, pos + 1)
                  || exist(board, i, j + 1, word, pos + 1);
    board[i][j] = word.charAt(pos);
    return result;
  }
}

