# [Palindrome Linked List][title]

## Description

Given a singly linked list, determine if it is a palindrome.

**Follow up:**

Could you do it in O(n) time and O(1) space?


## 思路

使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。

## 实现代码

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
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (slow.val != prev.val) {
        return false;
      }
      slow = slow.next;
      prev = prev.next;
    }

    return true;
  }
}
```

[title]: https://leetcode.com/problems/palindrome-linked-list

