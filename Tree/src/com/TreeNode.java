package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode generator(String input) {
        if (input.startsWith("[") && input.endsWith("]")) {
            String inputString = input.substring(1, input.length() - 1);
            String[] data = inputString.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(data[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count = 1;
            boolean left = true;
            TreeNode parent = null;
            while (!queue.isEmpty() && count < data.length) {
                if (left) {
                    parent = queue.poll();
                }
                String valStr = data[count];
                TreeNode node;
                if ("null".endsWith(valStr) || valStr == null || "".endsWith(valStr)) {
                    node = null;
                } else {
                    int val = Integer.parseInt(valStr);
                    node = new TreeNode(val);
                }
                if (left) {
                    parent.left = node;
                    left = false;
                } else {
                    parent.right = node;
                    left = true;
                }

                if (node != null) {
                    queue.offer(node);
                }
                count ++;
            }
            return root;
        }
        return null;
    }
}
