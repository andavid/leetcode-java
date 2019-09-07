/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
 *
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (43.13%)
 * Likes:    419
 * Dislikes: 632
 * Total Accepted:    55.2K
 * Total Submissions: 128K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes. More formally, the property root.val
 * = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 *
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   5
 * ⁠    / \
 * ⁠   5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest
 * value.
 *
 *
 *
 *
 */
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
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }

    if (root.left == null && root.right == null) {
      return -1;
    }

    int leftMin = root.left.val;
    if (leftMin == root.val) {
      leftMin = findSecondMinimumValue(root.left);
    }

    int rightMin = root.right.val;
    if (rightMin == root.val) {
      rightMin = findSecondMinimumValue(root.right);
    }

    if (leftMin == -1) {
      return rightMin;
    }

    if (rightMin == -1) {
      return leftMin;
    }

    return (leftMin < rightMin) ? leftMin : rightMin;
  }
}

