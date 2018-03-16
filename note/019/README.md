# [Remove Nth Node From End of List][title]

## Description

Given a linked list, remove the n<sup>th</sup> node from the end of list and return its head.

For example,

```
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given n will always be valid.
Try to do this in one pass.

## 思路

如果知道链表的长度，就可以从前往后一次遍历就可以了。但是求链表长度还需要遍历一次，因此总共需要两次遍历。题目要求使用一次遍历，可以使用两个指针来实现。初始都指向 head，第一个指针前进 N 步，然后两个指针同时前进直到第一个指针到达链表末尾，第二个指针后面的那个节点就是要移除的节点。

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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = head;
    ListNode second = head;

    for (int i = 1; i <= n; i++) {
      if (first.next == null) {
        return head.next;
      }
      first = first.next;
    }

    while (first.next != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return head;
  }
}
```

[title]: https://leetcode.com/problems/remove-nth-node-from-end-of-list
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_019/Solution.java
