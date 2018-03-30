class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 0) return false;
    while (n % 3 == 0) {
      n /= 3;
    }
    return n == 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPowerOfThree(3));
    System.out.println(solution.isPowerOfThree(5));
  }
}
