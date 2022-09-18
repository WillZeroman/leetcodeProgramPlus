package com;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int row = height;
        int colomn = (int) Math.pow(2, row) - 1;
        String[][] graph = new String[row][colomn];
        printTree(root, graph, 0, 0, colomn);
        List<List<String>> ans = new ArrayList<>();
        for (String[] rowString : graph) {
            List<String> list = new ArrayList<>();
            for (String item : rowString) {
                list.add(item == null ? "" : item);
            }
            ans.add(list);
        }
        return ans;
    }

    private void printTree(TreeNode node, String[][] graph, int row, int left, int right) {
        if (node == null) {
            return;
        }
        int mid = (left + right) / 2;
        graph[row][mid] = String.valueOf(node.val);
        if (node.left != null) {
            printTree(node.left, graph, row + 1, left, mid - 1);
        }
        if (node.right != null) {
            printTree(node.right, graph, row + 1, mid + 1, right);
        }
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        System.out.println(new PrintTree().printTree(root));
    }
}
