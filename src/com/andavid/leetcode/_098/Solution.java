class Solution {
  public static boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public static boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    return (min < root.val) && (root.val < max)
      && isValidBST(root.left, min, root.val)
      && isValidBST(root.right, root.val, max);
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
    TreeNode root = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(3);

    root.left = node1;
    root.right = node2;
    node1.left = node1.right = null;
    node2.left = node2.right = null;

    System.out.println(isValidBST(root));
  }

}
