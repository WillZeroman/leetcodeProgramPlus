package com.minDepth;

import com.TreeNode;

public class MinDepth {

    /**
     * 深度有限搜索算法求
     *
     * 时间：O(N)
     * 空间：O(H)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            return 1;
        }
    }
}
