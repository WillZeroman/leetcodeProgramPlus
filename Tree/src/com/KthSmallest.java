package com;

public class KthSmallest {

    int count;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return ans;
    }

    private boolean inorder(TreeNode node) {
        if(node!=null){
            boolean res = inorder(node.left);
            if(res){
                return true;
            }
            count --;
            if(count == 0){
                ans = node.val;
                return true;
            }
            res = inorder(node.right);
            if(res){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root,1));
        System.out.println(new KthSmallest().kthSmallest(root,2));
        System.out.println(new KthSmallest().kthSmallest(root,3));
        System.out.println(new KthSmallest().kthSmallest(root,4));
    }
}
