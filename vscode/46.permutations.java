/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.45%)
 * Likes:    2213
 * Dislikes: 67
 * Total Accepted:    406.6K
 * Total Submissions: 721.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    backtrace(nums, track, answer);
    return answer;
  }

  public void backtrace(int[] nums, List<Integer> track, List<List<Integer>> answer) {
    if (track.size() == nums.length) {
      answer.add(new ArrayList<Integer>(track));
    } else {
      for (int num : nums) {
        if (track.contains(num)) continue;
        track.add(num);
        backtrace(nums, track, answer);
        track.remove(track.size() - 1);
      }
    }
  }
}

