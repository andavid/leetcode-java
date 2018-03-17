class Solution {

  public static ListNode reverseList(ListNode head) {
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

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;

    ListNode node = reverseList(node1);
    while(node.next != null) {
      System.out.print(node.val + ",");
      node = node.next;
    }
    System.out.print(node.val);
  }

}
