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

    Solution solution = new Solution();
    ListNode node = solution.removeNthFromEnd(node1, 2);
    while(node.next != null) {
      System.out.print(node.val + ",");
      node = node.next;
    }
    System.out.print(node.val);
  }

}
