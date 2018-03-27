class Solution2 {
  public int rob(int[] nums) {
    int prev = 0;
    int curr = 0;

    for (int num : nums) {
      int temp = curr;
      curr = Math.max(num + prev, curr);
      prev = temp;
    }

    return curr;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {2, 1, 1, 2};
    System.out.println(solution.rob(nums));
  }
}
