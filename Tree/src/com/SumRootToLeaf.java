package com;

public class SumRootToLeaf {

    private int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preorder(root, 0);
        return ans;
    }

    public void preorder(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            ans += (sum << 1) + node.val;
            System.out.println(ans);
            return;
        }
        int nextSum = (sum << 1) + node.val;
        if (node.left != null) {
            preorder(node.left, nextSum);
        }
        if (node.right != null) {
            preorder(node.right, nextSum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        System.out.println(new SumRootToLeaf().sumRootToLeaf(root));
    }
}
