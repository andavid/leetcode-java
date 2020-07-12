/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (44.40%)
 * Likes:    818
 * Dislikes: 0
 * Total Accepted:    114.6K
 * Total Submissions: 256.2K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 *
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */

// @lc code=start
class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int res = 0;

    for (int num : nums) {
      int i = 0, j = res;
      // 二分查找 tails 数组，找到第一个大于 num 的数字
      while (i < j) {
        int mid = i + (j - i) / 2;
        if (tails[mid] < num) {
          i = mid + 1;
        } else {
          j = mid;
        }
      }
      tails[i] = num;
      if (j == res) {
        res++;
      }
    }

    return res;
  }
}
// @lc code=end

