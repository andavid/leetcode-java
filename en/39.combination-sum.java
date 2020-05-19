/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (50.27%)
 * Likes:    2327
 * Dislikes: 72
 * Total Accepted:    384.4K
 * Total Submissions: 763.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 *
 * Note:
 *
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    backtrace(list, new ArrayList<Integer>(), candidates, target, 0);
    return list;
  }

  public void backtrace(List<List<Integer>> list, List<Integer> track, int[] candidates, int remain, int start) {
    if (remain < 0) return;
    if (remain == 0) {
      list.add(new ArrayList<Integer>(track));
    } else {
      for (int i = start; i < candidates.length; i++) {
        track.add(candidates[i]);
        backtrace(list, track, candidates, remain - candidates[i], i);
        track.remove(track.size() - 1);
      }
    }
  }
}

