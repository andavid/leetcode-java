import java.util.*;

class Solution {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    queue.offer(null);

    TreeNode node;
    List<Integer> level = new ArrayList<>();
    while ((node = queue.poll()) != null || queue.peek() != null) {
      if (node == null) {
        queue.offer(null);
        list.add(level);
        level = new ArrayList<>();
        continue;
      }
      level.add(node.val);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    if (level.size() > 0) {
      list.add(level);
    }

    return list;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);
    root.left = node1;
    root.right = node2;
    node1.left = node1.right = null;
    node2.left = node3;
    node2.right = node4;
    node3.left = node3.right = null;
    node4.left = node4.right = null;

    Solution solution = new Solution();
    List<List<Integer>> list = solution.levelOrder(root);
    for (int i = 0; i < list.size(); i++) {
      List<Integer> level = list.get(i);
      for (int val : level) {
        System.out.print(val + " ");
      }
      System.out.println("");
    }
  }

}
