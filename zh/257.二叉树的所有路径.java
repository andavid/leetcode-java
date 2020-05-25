/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (63.85%)
 * Likes:    262
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 58.6K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new ArrayList<>();
    if (root != null) {
      dfs(list, "", root);
    }
    return list;
  }

  public void dfs(List<String> list, String path, TreeNode root) {
    if (root.left == null && root.right == null) {
      list.add(path + root.val);
    } else {
      if (root.left != null) {
        dfs(list, path + root.val + "->", root.left);
      }
      if (root.right != null) {
        dfs(list, path + root.val + "->", root.right);
      }
    }
  }
}
// @lc code=end

