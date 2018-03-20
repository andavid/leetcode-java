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

## 思路

递归。求二叉树 root 节点左子树和右子树的深度，其中较大的深度加 1 即为二叉树的深度。

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
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
```

[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_104/Solution.java
