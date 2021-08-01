package com;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int preorderI = 0;

        //buildTree(preorder,preorderI,inorder,indexOf(inorder,preorder[0]));


        return root;
    }

    private int indexOf(int[] data,int num){
        for(int i=0;i<data.length;i++){
            if(data[i] == num){
                return i;
            }
        }
        return -1;
    }

}
