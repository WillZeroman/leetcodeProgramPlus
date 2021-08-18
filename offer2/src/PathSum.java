import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    /**
     * 1) 节点值为负数
     * 2) 非叶子节点时就与target相等
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, target, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, Deque<Integer> path, List<List<Integer>> ans) {
        path.push(node.val);
        if (node.val == target && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        if (node.left != null) {
            dfs(node.left, target - node.val, path, ans);
        }
        if (node.right != null) {
            dfs(node.right, target - node.val, path, ans);
        }
        path.pop();
    }
}
