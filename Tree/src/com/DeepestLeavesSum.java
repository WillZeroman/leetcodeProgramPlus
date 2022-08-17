package com;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ans = 0;
            while (size-- > 0){
                TreeNode node = queue.poll();
                ans += node.val;
                Optional.ofNullable(node.left).ifPresent(p->queue.offer(p));
                Optional.ofNullable(node.right).ifPresent(p->queue.offer(p));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root));
    }
}
