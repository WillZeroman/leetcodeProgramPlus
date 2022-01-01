package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            TreeNode pre = queue.poll();
            if(!checkValid(pre.val,level)){
                return false;
            }
            if(pre.left!=null){
                list.add(pre.left);
            }
            if(pre.right!=null){
                list.add(pre.right);
            }
            while (!queue.isEmpty()){
                TreeNode current = queue.poll();
                if(!checkValid(current.val,level)){
                    return false;
                }
                if(current.left!=null){
                    list.add(current.left);
                }
                if(current.right!=null){
                    list.add(current.right);
                }
                int compare = pre.val - current.val;
                if(level%2==0&&compare<1 || level%2==1&&compare>1) {
                    continue;
                }else {
                    return false;
                }
            }
            queue.addAll(list);
            level ++;
        }
        return true;
    }

    private boolean checkValid(int val, int level) {
        if (level % 2 == 0 && val % 2 == 1) {
            return true;
        }
        if (val % 2 == 0 && level % 2 == 1) {
            return true;
        }
        return false;
    }
}
