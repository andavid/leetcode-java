/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (39.19%)
 * Likes:    1101
 * Dislikes: 46
 * Total Accepted:    257.8K
 * Total Submissions: 623.2K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * Example:
 *
 *
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    permute(nums, 0, answer);
    return answer;
  }

  public void permute(int[] nums, int begin, List<List<Integer>> answer) {
    if (begin == nums.length) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        list.add(nums[i]);
      }
      answer.add(list);
    } else {
      HashSet<Integer> set = new HashSet<>();
      for (int i = begin; i < nums.length; i++) {
        if (set.contains(nums[i])) continue;
        set.add(nums[i]);
        swap(nums, i, begin);
        permute(nums, begin + 1, answer);
        swap(nums, i, begin);
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

