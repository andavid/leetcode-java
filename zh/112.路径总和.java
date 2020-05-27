/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (49.67%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    77.8K
 * Total Submissions: 156.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 *
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
// @lc code=end

