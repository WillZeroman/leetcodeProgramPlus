package list;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        int val = head.val;
        ListNode curParent = head;
        ListNode current = head.next;
        while(current!=null){
            if(val!=current.val){
                curParent.next = current;
                curParent = curParent.next;
                val = current.val;
            }
            current = current.next;
        }
        curParent.next = current;
        return head;
    }

     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
