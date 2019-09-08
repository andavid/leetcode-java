# [Reverse Linked List][title]

## Description

Reverse a singly linked list.

**Hint:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

## 思路一

使用两个变量分别记录当前节点的前一个节点和后一个节点，当遍历链表的时候，将当前节点的 next 节点修改为前一个节点。

## 实现代码一

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
```

## 思路二

使用递归。

## 实现代码二

```java
class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
```

[title]: https://leetcode.com/problems/reverse-linked-list
