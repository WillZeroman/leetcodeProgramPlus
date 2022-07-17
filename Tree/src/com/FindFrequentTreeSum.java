package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        visit(root, map);
        int max = Collections.max(map.values());
        List<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                ans.add(key);
            }
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    private int visit(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftSum = 0;
        if (node.left != null) {
            leftSum = visit(node.left, map);
        }
        int rightSum = 0;
        if (node.right != null) {
            rightSum = visit(node.right, map);
        }
        int sum = leftSum + rightSum + node.val;
        int count = map.getOrDefault(sum, 0);
        count++;
        map.put(sum, count);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(new FindFrequentTreeSum().findFrequentTreeSum(root)));
    }
}
