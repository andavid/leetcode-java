/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (41.71%)
 * Likes:    965
 * Dislikes: 1468
 * Total Accepted:    260.6K
 * Total Submissions: 624.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2,
 * or index number 5 where the peak element is 6.
 *
 *
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 */
class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid1 = low + (high - low) / 2;
      int mid2 = mid1 + 1;
      if (nums[mid1] < nums[mid2]) {
        low = mid2;
      } else {
        high = mid1;
      }
    }
    return low;
  }
}

