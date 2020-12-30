package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/12/30 9:48
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，
 * 但是其方向必须向下(只能从父节点指向子节点方向)。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Slution_0412 {

    // 题目要求打印的是路径和等于 某一个值的所有路径
    // 但是路径并不一定是从根节点开始的 或者 并不是一定是叶子节点结束的，可以是任意节点开始和结束
    // 但必须是父节点 向 子节点的
    // 当然要使用 dfs ，深度优先搜索

    private List<String> res = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, 0);
        return res.size();
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, int curSum) {
        // base case
        if (root == null) {
            return;
        }
        // 只要有总和为 curSum 时，就加入结果
        if (sum == curSum) {
            res.add(String.valueOf(path));
        }
        // 使用深度优先遍历，但是要回溯
        curSum += root.val;
        path.add(root.val);
        dfs(root.left, sum, path, curSum);
        dfs(root.right, sum, path, curSum);
        // 回溯
        curSum -= root.val;
        path.remove(path.size() - 1);
    }

}
