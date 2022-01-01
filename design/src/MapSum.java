import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private TrieNode root = null;

    public MapSum() {
        root = new TrieNode('/');
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            TrieNode nextNode = node.children.getOrDefault(ch, new TrieNode(ch));
            node.children.put(ch, nextNode);
            node = nextNode;
        }
        node.end = true;
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode nextNode = node.children.get(ch);
            if (nextNode == null) {
                return 0;
            }
            node = nextNode;
        }
        return node.end ? node.val + sumNode(node) : sumNode(node);
    }

    private int sumNode(TrieNode node) {
        int sum = 0;
        for (TrieNode child : node.children.values()) {
            if (child.end) {
                sum += child.val;
            }
            sum += sumNode(child);
        }
        return sum;
    }

    class TrieNode {
        char ch;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end;
        int val;

        public TrieNode(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 5);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("ap", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
