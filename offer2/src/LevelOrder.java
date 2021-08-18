import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q1.offer(root);
        while (!q1.isEmpty()){
            List<Integer> list =new ArrayList<>();
            while (!q1.isEmpty()){
                TreeNode node = q1.poll();
                list.add(node.val);
                if(node.left!=null){
                    q2.offer(node.left);
                }
                if(node.right!=null){
                    q2.offer(node.right);
                }
            }
            ans.add(list);
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean leftFirst = true;
        while (!stack.isEmpty()){
            int size = stack.size();
            List<TreeNode> list = new ArrayList<>(size);
            List<Integer> ansList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = stack.pop();
                ansList.add(node.val);
                if(leftFirst){
                    if(node.left!=null){
                        list.add(node.left);
                    }
                    if(node.right!=null){
                        list.add(node.right);
                    }
                }else {
                    if(node.right!=null){
                        list.add(node.right);
                    }
                    if(node.left!=null){
                        list.add(node.left);
                    }
                }
            }
            ans.add(ansList);
            for(TreeNode node : list){
                stack.push(node);
            }
            leftFirst = !leftFirst;
        }
        return ans;
    }
}
