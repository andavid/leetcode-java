/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    // 1. 如果 p 和 q 都是 root 的后代，返回 p 和 q 的 LCA
    // 2. 如果 p 和 q 都不是 root 的后代，返回 null
    // 3. 如果 p 和 q 只有一个是 root 的后代，返回该后代(p 或 q)
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) {
      return right; // p 和 q 都不在左子树
    } else if (right == null) {
      return left; // p 和 q 都不在右子树
    } else {
      return root; // p 和 q 一个在左子树，一个在右子树
    }
  }
}

