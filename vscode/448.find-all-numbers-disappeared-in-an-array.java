/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (54.04%)
 * Likes:    1842
 * Dislikes: 170
 * Total Accepted:    174.7K
 * Total Submissions: 322.9K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 *
 */
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        list.add(i + 1);
      }
    }

    return list;
  }
}

