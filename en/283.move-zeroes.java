/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (53.64%)
 * Total Accepted:    448.5K
 * Total Submissions: 829.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
class Solution {
  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        nums[count++] = nums[i];
      }
    }
    while (count < n) {
      nums[count++] = 0;
    }
  }
}

