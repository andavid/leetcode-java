/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<TreeNode>();
    }
    return genTrees(1, n);
  }

  public List<TreeNode> genTrees(int start, int end) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    if (start > end) {
      list.add(null);
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = genTrees(start, i - 1);
      List<TreeNode> rightList = genTrees(i + 1, end);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          list.add(root);
        }
      }
    }

    return list;
  }
}

