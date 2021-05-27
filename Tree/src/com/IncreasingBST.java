package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = list.get(0);
        ans.left = null;
        for(int i=1;i<list.size();i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            cur.left = null;
        }
        return ans;
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            inorder(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            inorder(node.right, list);
        }
    }

    public static void main(String[] args) {
        String input = "[5,3,6,2,4,null,8,1,null,null,null,7,9]";
        TreeNode node = TreeNode.generator(input);
        System.out.println(node);
    }
}
