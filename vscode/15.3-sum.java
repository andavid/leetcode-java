/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.86%)
 * Likes:    4127
 * Dislikes: 475
 * Total Accepted:    595.1K
 * Total Submissions: 2.4M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) {
      return result;
    }

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int sum = -nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] == sum) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

    return result;
  }
}

