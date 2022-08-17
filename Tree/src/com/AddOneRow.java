package com;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 1;
            while (!queue.isEmpty()) {
                if (level == depth - 1) {
                    int size = queue.size();
                    while (size-- > 0) {
                        TreeNode cur = queue.poll();
                        TreeNode node = new TreeNode(val);
                        node.left = cur.left;
                        cur.left = node;
                        node = new TreeNode(val);
                        node.right = cur.right;
                        cur.right = node;
                    }
                    break;
                } else {
                    int size = queue.size();
                    while (size-- > 0) {
                        TreeNode cur = queue.poll();
                        if (cur.left != null) {
                            queue.offer(cur.left);
                        }
                        if (cur.right != null) {
                            queue.offer(cur.right);
                        }
                    }
                    level++;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        //    4
        //  2
        // 1 1
        //3   1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        System.out.println(new AddOneRow().addOneRow(root, 1, 3));
    }
}
