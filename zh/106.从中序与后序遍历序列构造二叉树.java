/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (68.64%)
 * Likes:    230
 * Dislikes: 0
 * Total Accepted:    39.9K
 * Total Submissions: 58K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
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
  private Map<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(postorder, postorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] postorder, int postIndex, int inStart, int inEnd) {
    if (postIndex < 0 || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postIndex]);
    int inIndex = map.get(postorder[postIndex]);
    int rightTreeSize = inEnd - inIndex;

    root.left = helper(postorder, postIndex - rightTreeSize - 1, inStart, inIndex - 1);
    root.right = helper(postorder, postIndex - 1, inIndex + 1, inEnd);

    return root;
  }
}
// @lc code=end

