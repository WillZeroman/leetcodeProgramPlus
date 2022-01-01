package com;

import org.w3c.dom.Node;

import java.util.List;

public class MaxDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        if (root.children != null) {
            for (Node node : root.children) {
                max = Math.max(max, maxDepth(node));
            }
        }
        return max + 1;
    }
}
