/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
  private HashMap<Integer, Integer> inMap = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    return helper(postorder, postorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode helper(int[] postorder, int postIndex, int inStart, int inEnd) {
    if (postIndex < 0 || inStart > inEnd) {
      return null;
    }

    // postIndex 指向后序遍历根节点的位置
    TreeNode root = new TreeNode(postorder[postIndex]);
    int inIndex = inMap.get(root.val);
    int rightTreeSize = inEnd - inIndex;

    root.left = helper(postorder, postIndex - rightTreeSize - 1, inStart, inIndex - 1);
    root.right = helper(postorder, postIndex - 1, inIndex + 1, inEnd);

    return root;
  }
}

