import java.util.*;

class Solution2 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root.left);
    stack.push(root.right);

    while (!stack.isEmpty()) {
      TreeNode left = stack.pop();
      TreeNode right = stack.pop();
      if (left == null && right == null) continue;
      if (left == null || right == null) return false;
      if (left.val != right.val) return false;
      stack.push(left.left);
      stack.push(right.right);
      stack.push(left.right);
      stack.push(right.left);
    }

    return true;
  }

  public boolean isSymmetric(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
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
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(3);

    root.left = node1;
    root.right = node2;
    node1.left = node3;
    node1.right = node4;
    node2.left = node5;
    node2.right = node6;
    node3.left = node3.right = null;
    node4.left = node4.right = null;
    node5.left = node5.right = null;
    node6.left = node6.right = null;

    Solution solution = new Solution();
    System.out.println(solution.isSymmetric(root));
  }

}
