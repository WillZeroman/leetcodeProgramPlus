package linked;

public class ReversePrint {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        ListNode cursor = head;
        while (cursor != null) {
            size++;
            cursor = cursor.next;
        }
        int[] res = new int[size];
        cursor = head;
        while (cursor != null) {
            size--;
            res[size] = cursor.val;
            cursor = cursor.next;
        }

        return res;
    }
}
