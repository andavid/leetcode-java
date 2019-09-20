/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (47.00%)
 * Likes:    1028
 * Dislikes: 78
 * Total Accepted:    247.6K
 * Total Submissions: 523.6K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 *
 * Input:
 *
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

