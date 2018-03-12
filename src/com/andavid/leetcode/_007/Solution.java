class Solution {
  public int reverse(int x) {
    long result = 0;
    for (; x != 0; x /= 10) {
      result = result * 10 + x % 10;
    }
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    }
    return (int)result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverse(123));
    System.out.println(solution.reverse(-123));
    System.out.println(solution.reverse(120));
  }
}
