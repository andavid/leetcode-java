class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int sum = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum = (sum < 0) ? nums[i] : (sum + nums[i]);
      if (sum > max) max = sum;
    }

    return max;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(solution.maxSubArray(nums));
  }
}
