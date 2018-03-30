class Solution2 {
  public boolean isPowerOfThree(int n) {
    return (n > 0) && (1162261467 % n == 0);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPowerOfThree(3));
    System.out.println(solution.isPowerOfThree(5));
  }
}
