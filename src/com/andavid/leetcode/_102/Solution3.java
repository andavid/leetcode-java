import java.util.*;

class Solution3 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    helper(res, root, 0);
    return res;
  }

  public void helper(List<List<Integer>> res, TreeNode root, int level) {
    if (root == null) return;
    if (level >= res.size()) {
      res.add(new ArrayList<Integer>());
    }
    res.get(level).add(root.val);
    helper(res, root.left, level + 1);
    helper(res, root.right, level + 1);
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
