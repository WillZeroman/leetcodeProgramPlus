import java.util.ArrayList;
import java.util.List;

public class TreeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            Node pre = list.get((i - 1 + list.size()) % list.size());
            Node next = list.get((i + 1 + list.size()) % list.size());
            node.left = pre;
            node.right = next;
        }
        return list.get(0);
    }

    private void inorder(Node node, List<Node> list) {
        if (node != null) {
            inorder(node.left, list);
            list.add(node);
            inorder(node.right, list);
        }
    }

    Node pre, head;

    public Node treeToDoublyList_best(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        dfs(node.left);
        if (pre != null) {
            pre.right = node;
        } else {
            head = pre;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}
