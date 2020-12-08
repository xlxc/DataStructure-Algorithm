package dfs;

import slidingWindow.MaxSlidingWindow;
import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

/**
 * @author: xuejing
 * @date: 2020/11/29 10:19
 * 337.打家劫舍
 */

public class Solution_337 {

    // 此题使用二叉树的递归套路解决吧
    // 对于某一个节点，列举出得到答案的可能性
    //  1) 当前节点偷，
    //      那么此时的结果就是，当前节点的值 + 左孩子节点不偷的情况下整棵树的最大值+右边孩子节点不偷
    //  2) 当前节点不偷
    //      那么此时左、右孩子可以偷也可以不偷，
    //       此时的结果就是 0+Max(左孩子节点偷，左孩子节点不偷) + Max(右孩子节点偷，右孩子节点不偷)
    // 列出所有的可能性后，确定需要向左右子树需要什么样的信息？
    // 当前节点偷，返回子树的最大和
    static class Info {
        public int yesSum;
        public int noSum;

        public Info() {
        }

        public Info(int yesSum, int noSum) {
            this.yesSum = yesSum;
            this.noSum = noSum;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Info res = dfs(root);
        return Math.max(res.yesSum, res.noSum);
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        int yes = root.val;
        int no = 0;
        // 先从左右节点拿东西
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        // 当前节点偷，那么此时左右节点就不能偷
        yes += leftInfo.noSum + rightInfo.noSum;
        // 当前节点不偷，那么此时左右节点可以偷也可以不偷，返回的的二者的最大值
        no += Math.max(leftInfo.yesSum,leftInfo.noSum) +  Math.max(rightInfo.yesSum,rightInfo.noSum);
        return new Info(yes, no);
    }

}
