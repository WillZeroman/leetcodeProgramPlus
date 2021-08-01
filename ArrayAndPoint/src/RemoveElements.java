public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode ans = node;
        while(node.next!=null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {

    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
