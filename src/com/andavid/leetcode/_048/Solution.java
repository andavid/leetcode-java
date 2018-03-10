class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i ++) {
      for (int j = i; j < n - 1 - i; j ++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 -j][i];
        matrix[n - 1 -j][i] = matrix[n - 1 -i][n - 1 -j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 -i];
        matrix[j][n - 1 -i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    solution.rotate(matrix);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(j == 0 ? matrix[i][j] : "," + matrix[i][j]);
      }
      System.out.println();
    }
  }
}
