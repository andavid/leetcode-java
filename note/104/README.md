# [Maximum Depth of Binary Tree][title]

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

```
    3
   / \
  9  20
    /  \
   15   7
```

return its depth = 3.

## 思路一

递归。求二叉树 root 节点左子树和右子树的深度，其中较大的深度加 1 即为二叉树的深度。

## 实现代码一

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
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
```

## 思路二

递归。带上当前节点的深度。

## 实现代码二

```java
class Solution {
  public int maxDepth(TreeNode root) {
    return maxDepth(root, 0);
  }

  public int maxDepth(TreeNode root, int depth) {
    if (root == null) {
      return depth;
    }
    return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
  }
}
```

[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree
