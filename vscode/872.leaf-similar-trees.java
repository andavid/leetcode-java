/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (63.01%)
 * Likes:    419
 * Dislikes: 24
 * Total Accepted:    50.9K
 * Total Submissions: 79.9K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree.  From left to right order, the
 * values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 *
 * Both of the given trees will have between 1 and 100 nodes.
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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    dfs(root1, list1);
    dfs(root2, list2);
    return (list1.toString()).equals(list2.toString());
  }

  public void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      list.add(root.val);
      return;
    }

    dfs(root.left, list);
    dfs(root.right, list);
  }
}

