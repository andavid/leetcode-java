/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    return lca(root, p, q);
  }

  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }

    if (p.val <= root.val && q.val >= root.val ||
        p.val >= root.val && q.val <= root.val) {
      return root;
    } else if (p.val < root.val && q.val < root.val) {
      return lca(root.left, p, q);
    } else {
      return lca(root.right, p, q);
    }
  }
}

