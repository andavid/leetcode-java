/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (44.97%)
 * Likes:    1205
 * Dislikes: 87
 * Total Accepted:    364K
 * Total Submissions: 794.7K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 */
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int sum = 0;
    int sub = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (Math.abs(nums[i] + nums[left] + nums[right] - target) < sub) {
          sum = nums[i] + nums[left] + nums[right];
          sub = Math.abs(sum - target);
        }
        if (nums[i] + nums[left] + nums[right] < target) {
          left++;
        } else {
          right--;
        }
      }
    }

    return sum;
  }
}

