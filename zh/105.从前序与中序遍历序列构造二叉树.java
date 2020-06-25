/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (67.06%)
 * Likes:    541
 * Dislikes: 0
 * Total Accepted:    88.9K
 * Total Submissions: 132.1K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (inorder == null || preorder == null || inorder.length != preorder.length) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(preorder, 0, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] preorder, int preIndex, int inStart, int inEnd) {
    if (preIndex > preorder.length - 1 || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preIndex]);
    int inIndex = map.get(preorder[preIndex]);
    int leftTreeSize = inIndex - inStart;

    root.left = helper(preorder, preIndex + 1, inStart, inIndex - 1);
    root.right = helper(preorder, preIndex + leftTreeSize + 1, inIndex + 1, inEnd);

    return root;
  }
}
// @lc code=end

