/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (47.33%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 49.5K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
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

      queue.offer(node.left);
      queue.offer(node.right);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).equals("null")) {
        list.remove(i);
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
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
    if (data == null || "[]".equals(data) || data.length() < 2) {
      return null;
    }

    String[] strArray = data.substring(1, data.length() - 1).split(",");
    Queue<String> list = new LinkedList<>();
    list.addAll(Arrays.asList(strArray));

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(list.poll()));
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      String leftVal = list.poll();
      if (leftVal == null || leftVal.equals("null")) {
        node.left = null;
      } else {
        TreeNode left = new TreeNode(Integer.parseInt(leftVal));
        node.left = left;
        queue.offer(left);
      }

      String rightVal = list.poll();
      if (rightVal == null || rightVal.equals("null")) {
        node.right = null;
      } else {
        TreeNode right = new TreeNode(Integer.parseInt(rightVal));
        node.right = right;
        queue.offer(right);
      }
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

