/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (33.03%)
 * Total Accepted:    365.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 *
 * Example:
 *
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
      }
    });

    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (!queue.isEmpty()) {
      curr.next = queue.poll();
      curr = curr.next;
      if (curr.next != null) {
        queue.add(curr.next);
      }
    }

    return dummy.next;
  }
}

