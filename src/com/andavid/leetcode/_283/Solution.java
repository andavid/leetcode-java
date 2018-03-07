class Solution {
  public void moveZeroes(int[] nums) {
    int len = nums.length;
    if (len < 2) return;

    int k = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != 0) {
        nums[k++] = nums[i];
      }
    }

    for(; k < len; k++) {
      nums[k] = 0;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {0, 1, 0, 3, 12};
    solution.moveZeroes(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i == 0 ? nums[i] : "," + nums[i]);
    }
  }
}
