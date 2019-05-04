# [Delete Node in a Linked List][title]

## Description

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is `1 -> 2 -> 3 -> 4` and you are given the third node with value `3`, the linked list should become `1 -> 2 -> 4` after calling your function.

## 思路

常规方法是修改该节点前面的那个节点。由于只能访问当前节点，且当前节点不是最末尾的节点，可以放心的把其 next 节点的值拷贝过来，并修改其 next 节点。

## 实现代码

```java
class Solution {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
```

[title]: https://leetcode.com/problems/delete-node-in-a-linked-list

