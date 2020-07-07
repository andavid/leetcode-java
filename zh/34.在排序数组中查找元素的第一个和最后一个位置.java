/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (39.56%)
 * Likes:    490
 * Dislikes: 0
 * Total Accepted:    105.8K
 * Total Submissions: 265.6K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */

// @lc code=start
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int left = searchLeft(nums, target, 0, nums.length - 1);
    if (left >= nums.length || nums[left] != target) {
      return new int[] {-1, -1};
    }

    int right = searchRight(nums, target, left, nums.length - 1);
    return new int[] {left, right};
  }

  public int searchLeft(int[] nums, int target, int start, int end) {
    int left = start;
    int right = end;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        right = mid - 1;
      }
    }

    return left;
  }

  public int searchRight(int[] nums, int target, int start, int end) {
    int left = start;
    int right = end;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        left = mid + 1;
      }
    }

    return right;
  }
}
// @lc code=end

