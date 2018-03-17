# [Reverse Linked List][title]

## Description

Reverse a singly linked list.

**Hint:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

## 思路

使用两个变量分别记录当前节点的前一个节点和后一个节点，当遍历链表的时候，将当前节点的 next 节点修改为前一个节点。

## [完整代码][src]

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

[title]: https://leetcode.com/problems/reverse-linked-list
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_206/Solution.java
