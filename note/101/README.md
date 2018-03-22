# [Symmetric Tree][title]

## Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:
```
    1
   / \
  2   2
   \   \
   3    3
```

**Note:**
Bonus points if you could solve it both recursively and iteratively.

## 思路

递归。

判断二叉树是不是对称的。从根节点开始遍历：
* 如果根节点为空，是对称的。
* 如果左右孩子节点都为空，只有一个根节点，也是对称的。
* 如果左右孩子节点只有一个为空，很明显是不对称的。
* 如果左右孩子节点都不为空，但是值不相等，也不是对称的。
* 如果左右孩子节点都不为空，且值相等，如果左孩子节点的左子树与右孩子节点的右子树是对称的，并且左孩子节点的右子树与右孩子节点的左子树是对称的，则二叉树是对称的。

## [完整代码][src]

```java
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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
  }
}
```

[title]: https://leetcode.com/problems/symmetric-tree
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_101/Solution.java
