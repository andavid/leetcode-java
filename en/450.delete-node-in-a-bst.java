/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (39.80%)
 * Likes:    939
 * Dislikes: 59
 * Total Accepted:    68.3K
 * Total Submissions: 170.1K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 *
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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
  public TreeNode deleteNode(TreeNode root, int data) {
    TreeNode p = root;
    TreeNode parent = null;

    while (p != null && p.val != data) {
      parent = p;
      if (data < p.val) {
        p = p.left;
      } else {
        p = p.right;
      }
    }

    if (p == null) {
      return root; // 没有找到要删除的节点
    }

    // 要删除的节点有两个孩子节点
    if (p.left != null && p.right != null) {
      TreeNode minNode = p.right;
      TreeNode minNodeParent = p;
      // 找到右子树的最小节点，替换到要删除的节点上
      while (minNode.left != null) {
        minNodeParent = minNode;
        minNode = minNode.left;
      }
      p.val = minNode.val;
      // 要删除的节点变成了右子树的最小节点
      // 由于该节点肯定不会有左孩子，因此可以使用接下来的代码进行删除
      p = minNode;
      parent = minNodeParent;
    }

    // 删除叶子节点，或者只有一个孩子的节点
    TreeNode child;
    if (p.left != null) {
      child = p.left;
    } else if (p.right != null) {
      child = p.right;
    } else {
      child = null;
    }

    if (parent == null) {
      // 删除的是根节点
      root = child;
    } else if (parent.left == p) {
      parent.left = child;
    } else {
      parent.right = child;
    }

    return root;
  }
}

