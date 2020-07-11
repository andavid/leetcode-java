/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (69.29%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    77.4K
 * Total Submissions: 111K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 * 说明：
 *
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 */

// @lc code=start
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums2);

    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      if (!set.contains(num) && bsearch(nums2, num)) {
        set.add(num);
      }
    }

    int[] result = new int[set.size()];
    int index = 0;
    for (int num : set) {
      result[index++] = num;
    }

    return result;
  }

  public boolean bsearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }

    return false;
  }
}
// @lc code=end

