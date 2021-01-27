package nowcoder;

import utils.TreeNode;

/**
 * @author: xuejing
 * @date: 2021/01/27 9:42
 * 给定一个二叉树和一个值 sum sum，判断是否有从根节点到叶子节点的节点值之和等于 sum sum 的路径，
 * 例如：
 * 给出如下的二叉树， sum=22 sum=22，
 */
public class TreeHasPathSum {

    /* 此题是典型的 dfs 的题目，使用深度优先搜索遍历，递归实现，注意递归的 base case 即可*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        // 若当前节点是叶子节点
        // 同时题目要求的是否范湖是否存在符合的一条路径，所以我们不需要全部遍历完正棵树，只要找到九直接返回即可
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        // 若不是叶子节点，则递归的去其左右孩子节点进行搜索
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
