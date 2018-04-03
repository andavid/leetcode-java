class Solution {
  public int missingNumber(int[] nums) {
    int total = nums.length * (nums.length + 1) / 2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return total - sum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {9,6,4,2,3,5,7,0,1};
    System.out.println(solution.missingNumber(nums));
  }
}
