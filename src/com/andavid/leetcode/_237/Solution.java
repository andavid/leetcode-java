class Solution {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

}
