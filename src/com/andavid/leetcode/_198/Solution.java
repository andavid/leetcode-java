class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int past = nums[0];
    int prev = Math.max(nums[0], nums[1]);
    int max = prev;

    for (int i = 2; i < nums.length; i++) {
      int sum = past + nums[i];
      if (prev > sum) sum = prev;
      past = prev;
      prev = sum;
      if (sum > max) max = sum;
    }

    return max;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {2, 1, 1, 2};
    System.out.println(solution.rob(nums));
  }
}
