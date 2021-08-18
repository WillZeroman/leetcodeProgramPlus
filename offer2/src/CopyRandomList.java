import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        Node preNode = null;
        while (cur!=null){
            Node temp = new Node(cur.val);
            if(preNode == null){
                preNode = temp;
            }else {
                preNode.next = temp;
                preNode = preNode.next;
            }
            map.put(cur,temp);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            Node node = map.get(cur);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private Map<Node,Node> cache = new HashMap<>();
    public Node copyRandomList_back(Node head){
        if(head == null){
            return null;
        }
        if(!cache.containsKey(head)){
            Node node = new Node(head.val);
            cache.put(head,node);
            node.next = copyRandomList_back(node.next);
            node.random = copyRandomList_back(node.random);
        }
        return cache.get(head);
    }
}
