# [Merge Two Sorted Lists][title]

## Description

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

## 思路一

遍历两个链表，比较两个链表节点的大小，修改当前节点使其指向较小的那个节点。

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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if (l1 != null) {
      curr.next = l1;
    }

    if (l2 != null) {
      curr.next = l2;
    }

    return dummy.next;
  }
}
```

## 思路二

递归。

比较两个链表头节点的大小，指向较小的节点，并且该节点的 next 节点可以通过递归的方法得到。

## [完整代码][src2]

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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l2.next, l1);
      return l2;
    }
  }
}
```

[title]: https://leetcode.com/problems/merge-two-sorted-lists
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_021/Solution.java
[src2]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_021/Solution2.java
