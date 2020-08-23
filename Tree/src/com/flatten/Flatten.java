package com.flatten;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将二叉树展开为链表
 *
 * 解法二： 寻找前驱节点
 */
public class Flatten {
    /**
     * 解法一
     * 1) 前序遍历， 存储在 list中
     * 2）依次访问 list，得到的顺序即为单链表顺序
     *
     * 时间：O(n)
     * 空间：O(n)
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode first = list.get(i);
            first.left = null;
            // 最后一个node 特殊处理
            if (i + 1 < list.size()) {
                first.right = list.get(i + 1);
            } else {
                first.right = null;
            }
        }

    }

    /**
     * 前序遍历
     *
     * @param node
     * @param list
     */
    private void preorderTraversal(TreeNode node, List<TreeNode> list) {
        if (node != null) {
            list.add(node);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }



    /**
     * 错误的思路，递归直接求解
     *
     * @param node
     * @param left
     * @param right
     */
    private void flatten(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null) {
            return;
        }
        if (left == null && right == null) {
            return;
        }
        if (left != null) {
            flatten(left, left.left, left.right);
            node.left = null;
            node.right = left;
            if (right != null) {
                flatten(right, right.left, right.right);
            }
            left.right = right;
        } else {
            if (right != null) {
                flatten(right, right.left, right.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(root);
        new Flatten().flatten(root);
        System.out.println(root);

    }
}
