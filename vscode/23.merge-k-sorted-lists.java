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

    ListNode head = null, curr = null;
    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }

    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      if (head == null) {
        head = curr = node;
      } else {
        curr.next = node;
        curr = curr.next;
      }
      if (node.next != null) {
        queue.add(node.next);
      }
    }

    return head;
  }
}

