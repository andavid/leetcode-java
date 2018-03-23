import java.util.*;

class Solution2 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) return list;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.peek();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        temp.add(queue.poll().val);
      }
      list.add(temp);
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
