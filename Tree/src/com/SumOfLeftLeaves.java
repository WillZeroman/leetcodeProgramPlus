package com;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return travel(root, false);
    }

    private int travel(TreeNode node, boolean isLeft) {
        int sum = 0;
        if (node.left != null) {
            sum += travel(node.left, true);
        }
        if (node.right != null) {
            sum += travel(node.right, false);
        }
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }
        return sum;
    }

}
