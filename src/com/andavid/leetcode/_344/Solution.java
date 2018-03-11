class Solution {
  public String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverseString("hello"));
  }
}
