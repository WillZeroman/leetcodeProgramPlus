package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> visited = new LinkedList<>();
        visited.add(root.val);
        dfs(result, visited, root, sum);

        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> visited, TreeNode node, int sum) {
        if (node.val == sum) {
            if (node.left == null && node.right == null) {
                // found successfully
                result.add(new ArrayList<>(visited));
                return;
            }
        }
//        if (node.val > sum) {
//            return;
//        }
        if (node.left != null) {
            visited.add(node.left.val);
            dfs(result,visited,node.left,sum-node.val);
            visited.removeLast();
        }
        if (node.right != null) {
            visited.add(node.right.val);
            dfs(result,visited,node.right,sum-node.val);
            visited.removeLast();
        }
    }
}
