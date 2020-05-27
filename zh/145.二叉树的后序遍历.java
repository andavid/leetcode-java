/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (71.46%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    80.2K
 * Total Submissions: 112.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * 输出: [3,2,1]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    TreeNode last = null;

    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }

      p = stack.peek();
      if (p.right == null || p.right == last) {
        result.add(p.val);
        stack.pop();
        last = p;
        p = null;
      } else {
        p = p.right;
      }
    }

    return result;
  }
}
// @lc code=end

