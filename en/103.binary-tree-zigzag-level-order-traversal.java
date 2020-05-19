/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (41.42%)
 * Likes:    984
 * Dislikes: 60
 * Total Accepted:    225.4K
 * Total Submissions: 536.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 *
 *
 * return its zigzag level order traversal as:
 *
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.empty() || !stack2.empty()) {
      List<Integer> level = new ArrayList<>();
      if (!stack1.empty()) {
        while (!stack1.empty()) {
          TreeNode node = stack1.pop();
          level.add(node.val);
          if (node.left != null) stack2.push(node.left);
          if (node.right != null) stack2.push(node.right);
        }
      } else {
        while (!stack2.empty()) {
          TreeNode node = stack2.pop();
          level.add(node.val);
          if (node.right != null) stack1.push(node.right);
          if (node.left != null) stack1.push(node.left);
        }
      }
      list.add(level);
    }

    return list;
  }
}

