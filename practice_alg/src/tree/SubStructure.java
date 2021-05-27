package tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A != null && B != null) {
            int firstVal = B.val;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(A);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.val == firstVal) {
                    if (compare(node, B)) {
                        return true;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            return false;
        } else {
            return false;
        }
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return compare(node1.left, node2.left) && compare(node1.right, node2.right);
        }
        return false;
    }

    public static void main(String[] args) {
//        [4,2,3,4,5,6,7,8,9]
//[4,8,9]
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);
        a.left.left.left = new TreeNode(8);
        a.left.left.right = new TreeNode(9);
        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(8);
        b.right = new TreeNode(9);
        System.out.println(new SubStructure().isSubStructure(a, b));
        //[10,12,6,8,3,11]
        //[10,12,6,8]
        a = new TreeNode(10);
        a.left = new TreeNode(12);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(8);
        a.left.right = new TreeNode(3);
        a.right.left = new TreeNode(11);

        b = new TreeNode(10);
        b.left = new TreeNode(12);
        b.right = new TreeNode(6);
        b.left.left = new TreeNode(8);
        System.out.println(new SubStructure().isSubStructure(a, b));
    }
}
