package com;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{1,2}));
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{1}));
    }
}
