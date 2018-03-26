class Solution {
  public int climbStairs(int n) {
    if (n == 1) return 1;

    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.climbStairs(1));
    System.out.println(solution.climbStairs(2));
    System.out.println(solution.climbStairs(3));
    System.out.println(solution.climbStairs(4));
  }
}
