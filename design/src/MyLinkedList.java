public class MyLinkedList {
    private Entry head;

    private int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Entry cursor = head;
        while (index-- > 0) {
            cursor = cursor.next;
        }
        return cursor.val;
    }

    public void addAtHead(int val) {
        Entry entry = new Entry();
        entry.val = val;
        entry.next = head;
        head = entry;
        size++;
    }

    public void addAtTail(int val) {
        Entry entry = new Entry();
        entry.val = val;
        if (head == null) {
            head = entry;
        } else {
            Entry cursor = head;
            while (cursor.next != null) {
                cursor = cursor.next;
            }
            cursor.next = entry;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Entry entry = new Entry();
        entry.val = val;
        if (head == null) {
            head = entry;
        } else {
            if (index <= 0) {
                entry.next = head;
                head = entry;
            } else {
                Entry cursor = head;
                while (--index > 0) {
                    cursor = cursor.next;
                }
                entry.next = cursor.next;
                cursor.next = entry;
            }
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Entry cursor = head;
            while (--index > 0) {
                cursor = cursor.next;
            }
            cursor.next = cursor.next.next;
        }
        size--;
    }

    class Entry {
        int val;
        Entry next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));           //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }
}
