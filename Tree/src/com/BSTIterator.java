package com;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

    public BSTIterator(TreeNode root) {
        addNode(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node == null){
            return -1;
        }
        if (node.right != null) {
            addNode(node.right);
        }
        return node.val;
    }

    private void addNode(TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
