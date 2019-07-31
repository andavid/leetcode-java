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
    backtrace(nums, 0, new ArrayList<Integer>(), answer);
    return answer;
  }

  public void backtrace(int[] nums, int start, List<Integer> track, List<List<Integer>> answer) {
    answer.add(new ArrayList<>(track));
    for (int i = start; i < nums.length; i++) {
      track.add(nums[i]);
      backtrace(nums, i + 1, track, answer);
      track.remove(track.size() - 1);
    }
  }
}

