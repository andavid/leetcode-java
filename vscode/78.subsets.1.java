/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (52.37%)
 * Likes:    2152
 * Dislikes: 53
 * Total Accepted:    391.7K
 * Total Submissions: 725K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    int bitNumber = nums.length;
    int power = 1 << bitNumber;
    for (int i = 0; i < power; i++) {
      List<Integer> list = new ArrayList<>();
      int bit = i;
      int count = 0;
      while (bit != 0) {
        if ((bit & 1) == 1) {
          list.add(nums[count]);
        }
        count++;
        bit = bit >> 1;
      }
      answer.add(new ArrayList<>(list));
    }
    return answer;
  }
}

