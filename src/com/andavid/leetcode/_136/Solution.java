class Solution {
  public int singleNumber(int[] nums) {
    int n = 0;
    for (int num : nums) {
      n ^= num;
    }
    return n;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.singleNumber(new int[]{1, 2, 1}));
  }
}
