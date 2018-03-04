class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - k - 1);
    reverse(nums, n - k, n - 1);
    reverse(nums, 0, n - 1);
  }

  private void reverse(int[] nums, int from, int to) {
    while (from < to) {
      int temp = nums[from];
      nums[from++] = nums[to];
      nums[to--] = temp;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    solution.rotate(nums, 3);
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      System.out.print(nums[i] + (i == len - 1 ? "" : ", "));
    }
  }
}
