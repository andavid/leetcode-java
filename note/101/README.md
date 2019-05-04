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

## 思路一：递归

判断二叉树是不是对称的。从根节点开始遍历：
* 如果根节点为空，是对称的。
* 如果左右孩子节点都为空，只有一个根节点，也是对称的。
* 如果左右孩子节点只有一个为空，很明显是不对称的。
* 如果左右孩子节点都不为空，但是值不相等，也不是对称的。
* 如果左右孩子节点都不为空，且值相等，如果左孩子节点的左子树与右孩子节点的右子树是对称的，并且左孩子节点的右子树与右孩子节点的左子树是对称的，则二叉树是对称的。

## 实现代码

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

## 思路二：迭代

维护一个栈。从根节点开始，压入其左孩子节点和右孩子节点，然后依次弹出，比较其是否为空，如果都不为空并且值也相等，则依次压入左孩子的左孩子节点、右孩子的右孩子节点、左孩子的右孩子节点、右孩子的左孩子节点。

## [完整代码][src2]

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
}
```

[title]: https://leetcode.com/problems/symmetric-tree

[src2]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_101/Solution2.java
