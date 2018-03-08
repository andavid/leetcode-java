# [Valid Sudoku][title]

## Description

Determine if a Sudoku is valid, according to: [Sudoku Puzzles - The Rules][sudoku].

The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A partially filled sudoku which is valid.

**Note:**
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

## 思路
每个数字，在每一行、每一列、每一个小九宫格内，只能出现一次。

使用 3 个 9*9 的数组，记录每一行、每一列、每一个小九宫格里 1-9 出现的情况，如果某个数字出现，该将数字对应的位置置为 true。

因此，只需要从左往右，从上到下，依次遍历 board 里的数字，一旦发现数字所在的行、列或小九宫格里该数字对应的位置为 true，说明不是有效的数独。

## [完整代码][src]

```java
import java.util.HashSet;

public class Solution {
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
}
```

[title]: https://leetcode.com/problems/valid-sudoku
[sudoku]: http://sudoku.com.au/TheRules.aspx
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_036/Solution.java
