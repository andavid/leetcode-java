/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class Solution {
  public int search(int[] nums, int target) {
    return bsearch(nums, target, 0, nums.length - 1);
  }

  public int bsearch(int[] nums, int target, int low, int high) {
    if (low > high) return -1;

    int mid = low + ((high - low) >> 1);
    if (nums[mid] == target) {
      return mid;
    } else if (nums[low] == target) {
      return low;
    } else if (nums[high] == target) {
      return high;
    } else if (nums[low] < nums[mid]) {
      if (nums[low] < target && target < nums[mid]) {
        return bsearch(nums, target, low + 1, mid - 1);
      } else {
        return bsearch(nums, target, mid + 1, high - 1);
      }
    } else {
      if (nums[mid] < target && target < nums[high]) {
        return bsearch(nums, target, mid + 1, high - 1);
      } else {
        return bsearch(nums, target, low + 1, mid - 1);
      }
    }
  }
}

