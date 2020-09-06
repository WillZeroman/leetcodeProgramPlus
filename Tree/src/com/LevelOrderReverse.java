package com;

import java.util.*;

/**
 * 方法一：层次遍历，反向输出
 * 1）queue and stack
 * 2）两个队列
 * 3） O（n） O（n）
 * 方法二： 广度优先搜索算法 + 头插法
 */
public class LevelOrderReverse {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<List<Integer>> res = new ArrayDeque<>();
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
                res.push(new ArrayList<>(tempLevelNode));
                tempLevelNode.clear();
            }
        }

        return new ArrayList<>(res);
    }
}
