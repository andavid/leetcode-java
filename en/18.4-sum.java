/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.29%)
 * Likes:    1164
 * Dislikes: 235
 * Total Accepted:    248K
 * Total Submissions: 799.2K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 4) {
      return result;
    }

    Arrays.sort(nums);

    for (int j = 0; j < nums.length - 3; j++) {
      if (j > 0 && nums[j] == nums[j - 1]) {
        continue;
      }
      for (int i = j + 1; i < nums.length - 2; i++) {
        if (i > j + 1 && nums[i] == nums[i - 1]) {
          continue;
        }
        int sum = target - nums[j] - nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
          if (nums[left] + nums[right] == sum) {
            result.add(Arrays.asList(nums[j], nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          } else if (nums[left] + nums[right] < sum) {
            left++;
          } else {
            right--;
          }
        }
      }
    }

    return result;
  }
}

