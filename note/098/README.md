# [Validate Binary Search Tree][title]

## Description

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right subtrees must also be binary search trees.

**Example 1:**

```
    2
   / \
  1   3
```

Binary tree `[2,1,3]`, return true.

**Example 2:**

```
    1
   / \
  2   3
```

Binary tree `[1,2,3]`, return false.

## 思路
递归。带上两个参数，分别表示最小值和最大值。
左子树的最大值要小于根节点，右子树的最小值要大于根节点。

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
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    return (min < root.val) && (root.val < max)
      && isValidBST(root.left, min, root.val)
      && isValidBST(root.right, root.val, max);
  }
}
```

[title]: https://leetcode.com/problems/validate-binary-search-tree
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_098/Solution.java
