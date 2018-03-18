# [Linked List Cycle][title]

## Description

Given a linked list, determine if it has a cycle in it.

Follow up:  
Can you solve it without using extra space?

## 思路

使用快慢两个指针，慢指针每次前进一步，快指针每次前进两步，如果慢指针和快指针相等，说明有环。


## [完整代码][src]

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
```

[title]: https://leetcode.com/problems/linked-list-cycle
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_141/Solution.java
