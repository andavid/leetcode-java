/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    return helper(preorder, 0, 0, inorder.length - 1);
  }

  public TreeNode helper(int[] preorder, int preIndex, int inStart, int inEnd) {
    if (preIndex > preorder.length - 1 || inStart > inEnd) {
      return null;
    }

    // preIndex 指向前序遍历根节点的位置
    TreeNode root = new TreeNode(preorder[preIndex]);
    int inIndex = inMap.get(root.val);
    int leftTreeSize = inIndex - inStart;

    root.left = helper(preorder, preIndex + 1, inStart, inIndex - 1);
    root.right = helper(preorder, preIndex + leftTreeSize + 1, inIndex + 1, inEnd);

    return root;
  }
}

