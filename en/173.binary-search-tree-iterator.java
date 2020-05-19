/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

  public Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<TreeNode>();
    TreeNode p = root;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode p = stack.pop();
    int number = p.val;
    p = p.right;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
    return number;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

