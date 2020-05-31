/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (76.06%)
 * Likes:    721
 * Dislikes: 0
 * Total Accepted:    133K
 * Total Submissions: 174.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 */

// @lc code=start
class Solution {
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    List<Integer> track = new ArrayList<>();
    backtrack(nums, track);
    return result;
  }

  public void backtrack(int[] nums, List<Integer> track) {
    if (track.size() == nums.length) {
      result.add(new ArrayList(track));
      return;
    }

    for (int num : nums) {
      if (track.contains(num)) {
        continue;
      }
      track.add(num);
      backtrack(nums, track);
      track.remove(track.size() - 1);
    }
  }
}
// @lc code=end

