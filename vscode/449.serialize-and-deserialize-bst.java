/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (46.77%)
 * Likes:    649
 * Dislikes: 48
 * Total Accepted:    60.7K
 * Total Submissions: 127.9K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your
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
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  public void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val + ",");
    buildString(root.left, sb);
    buildString(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("")) {
      return null;
    }
    String[] strs = data.split(",");
    Queue<Integer> queue = new LinkedList<>();
    for (String str : strs) {
      queue.offer(Integer.valueOf(str));
    }
    return buildTree(queue);
  }

  public TreeNode buildTree(Queue<Integer> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(queue.poll());
    Queue<Integer> smallerQueue = new LinkedList<>();
    while (!queue.isEmpty() && queue.peek() < root.val) {
      smallerQueue.offer(queue.poll());
    }
    root.left = buildTree(smallerQueue);
    root.right = buildTree(queue);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

