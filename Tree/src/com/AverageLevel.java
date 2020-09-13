package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> thisLevelQueue = new LinkedList<>();
        Queue<TreeNode> nextLevelQueue = new LinkedList<>();
        thisLevelQueue.offer(root);
        List<Integer> tempLevelNode = new ArrayList<>();
        while (!thisLevelQueue.isEmpty()) {
            TreeNode node = thisLevelQueue.poll();
            tempLevelNode.add(node.val);
            if (node.left != null) {
                nextLevelQueue.offer(node.left);
            }
            if (node.right != null) {
                nextLevelQueue.offer(node.right);
            }
            if (thisLevelQueue.isEmpty()) {
                Queue<TreeNode> temp = thisLevelQueue;
                thisLevelQueue = nextLevelQueue;
                nextLevelQueue = temp;
                // double ，避免int溢出
                double sum = 0;
                for (Integer integer : tempLevelNode) {
                    sum += integer;
                }
                res.add(sum / tempLevelNode.size());
                tempLevelNode.clear();
            }
        }
        return res;
    }
}
