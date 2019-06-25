/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (39.42%)
 * Likes:    1558
 * Dislikes: 75
 * Total Accepted:    190.5K
 * Total Submissions: 461.5K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * Example: 
 *
 *
 * You may serialize the following tree:
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 *
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }

    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        list.add("null");
        continue;
      } else {
        list.add("" + node.val);
      }

      if (node.left != null) {
        queue.offer(node.left);
      } else {
        queue.offer(null);
      }

      if (node.right != null) {
        queue.offer(node.right);
      } else {
        queue.offer(null);
      }
    }

    // 移除末尾的 null
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).equals("null")) {
        list.remove(i);
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i == list.size() - 1) {
        sb.append("]");
      } else {
        sb.append(",");
      }
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("[]") || data.length() <= 2) {
      return null;
    }

    String[] strArray = data.substring(1, data.length() - 1).split(",");
    Queue<String> list = new LinkedList<>();
    list.addAll(Arrays.asList(strArray));

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.valueOf(list.poll()));
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      String leftVal = list.poll();
      if (leftVal == null || leftVal.equals("null")) {
        node.left = null;
      } else {
        TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal));
        node.left = leftNode;
        queue.offer(leftNode);
      }

      String rightVal = list.poll();
      if (rightVal == null || rightVal.equals("null")) {
        node.right = null;
      } else {
        TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal));
        node.right = rightNode;
        queue.offer(rightNode);
      }
    }

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

