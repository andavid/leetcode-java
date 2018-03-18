class Solution2 {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode l11 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(4);
    ListNode l21 = new ListNode(1);
    ListNode l22 = new ListNode(3);
    ListNode l23 = new ListNode(4);
    l11.next = l12;
    l12.next = l13;
    l13.next = null;
    l21.next = l22;
    l22.next = l23;
    l23.next = null;

    ListNode node = mergeTwoLists(l11, l21);
    while(node.next != null) {
      System.out.print(node.val + ",");
      node = node.next;
    }
    System.out.print(node.val);
  }

}
