/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.61%)
 * Total Accepted:    801.6K
 * Total Submissions: 2.6M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example:
 *
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;

    while (p1 != null || p2 != null) {
      sum /= 10;

      if (p1 != null) {
        sum += p1.val;
        p1 = p1.next;
      }

      if (p2 != null) {
        sum += p2.val;
        p2 = p2.next;
      }

      p.next = new ListNode(sum % 10);
      p = p.next;
    }

    if (sum / 10 == 1) {
      p.next = new ListNode(1);
    }

    return dummy.next;
  }
}

