package backtracking;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/12/09 10:23
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution_113 {

    /**
     * 本题采用深度优先搜索遍历，使用的是回溯+剪枝的过程
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // base case
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int rest, List<Integer> path, List<List<Integer>> res) {
        // base case
        // 当前已经走到了叶子节点，或者说当前节点是空的
        if (root == null) {
            return;
        }
        // 加入路径
        path.add(root.val);
        rest -= root.val;
        // 判断当前是否是叶子节点
        if (root.left == null && root.right == null && rest == 0) {
            res.add(new ArrayList<>(path));
        }
        // 先去左子树递归
        dfs(root.left, rest, path, res);
        // 去右子树递归
        dfs(root.right, rest, path, res);
        path.remove(path.size() - 1);
    }

}
