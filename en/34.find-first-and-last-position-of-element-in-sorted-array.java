/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.42%)
 * Likes:    1790
 * Dislikes: 91
 * Total Accepted:    326.2K
 * Total Submissions: 961.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};

    int first = bsearchFirst(nums, target, 0, nums.length - 1);
    if (first == -1) {
      return result;
    }

    result[0] = first;
    result[1] = bsearchLast(nums, target, first, nums.length - 1);

    return result;
  }

  public int bsearchFirst(int[] nums, int target, int low, int high) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] < target) {
        low = mid + 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        if (mid == 0 || nums[mid - 1] != target) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  public int bsearchLast(int[] nums, int target, int low, int high) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] < target) {
        low = mid + 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        if (mid == nums.length - 1 || nums[mid + 1] != target) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }
}

