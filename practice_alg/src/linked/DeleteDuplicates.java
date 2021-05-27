package linked;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preCursor = head;
        ListNode cursor = head.next;
        int val = head.val;
        while(cursor!=null){
            if(val!=cursor.val){
                preCursor.next = cursor;
                preCursor = preCursor.next;
            }
            val = cursor.val;
            cursor = cursor.next;
        }
        preCursor.next = null;
        return head;
    }
}
