/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (44.33%)
 * Likes:    4310
 * Dislikes: 80
 * Total Accepted:    339.3K
 * Total Submissions: 761.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 *
 * Example:
 *
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 */
class Solution {
  public int trap(int[] height) {
    int n = height.length;
    if (n <= 1) {
      return 0;
    }

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = height[0];
    rightMax[n-1] = height[n-1];

    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i-1], height[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i+1], height[i]);
    }

    int res = 0;
    for (int i = 1; i < n - 1; i++) {
      res += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return res;
  }
}

