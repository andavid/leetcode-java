/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (49.23%)
 * Total Accepted:    83.5K
 * Total Submissions: 168.7K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 *
 *
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    Stack<Integer> stack1 = buildStack(l1);
    Stack<Integer> stack2 = buildStack(l2);
    int sum = 0;
    ListNode dummy = new ListNode(-1);

    while (!stack1.empty() || !stack2.empty() || (sum / 10 == 1) ) {
      sum /= 10;
      if (!stack1.empty()) {
        sum += stack1.pop();
      }
      if (!stack2.empty()) {
        sum += stack2.pop();
      }
      ListNode node = new ListNode(sum % 10);
      node.next = dummy.next;
      dummy.next = node;
    }

    return dummy.next;
  }

  public Stack<Integer> buildStack(ListNode l) {
    Stack<Integer> stack = new Stack<>();
    while (l != null) {
      stack.push(l.val);
      l = l.next;
    }
    return stack;
  }
}

