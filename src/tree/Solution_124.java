package tree;

import com.sun.corba.se.spi.transport.ReadTimeouts;
import utils.TreeNode;

import javax.sound.sampled.DataLine.Info;
import java.util.function.LongFunction;

/**
 * @author: xuejing
 * @date: 2020/12/18 10:33
 * 124.二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_124 {
    public static void main(String[] args) {

    }

    // 本题可以使用 二叉树的递归套路来解决
    // 对于当前某个节点，其最大的路径和为：
    // 1) 若当前节点的值是负数，那么其最大的路径和 = 左子树的最大路径和、右子树的最大路径和、左子树+右子树 这三者中的最大值
    // 2) 若当前节点的值不是负数，那么最大的路径和 = 上一步的最大值 + 当前节点的值
    // 综上：当前节点的最大路径和 =  左子树的最大路径和、右子树的最大路径和、左子树+右子树 这三者中的最大值
    // 若当前节点的值 是正数 则加上，若是负数，则不加

    // 由于全局的最大和并不是从根节点开始的，所以需要用一个变量来计算
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return maxSum;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这里要筛选，如果返回的是负数，就不要
        int left = Math.max(0, process(root.left));
        int right = Math.max(0, process(root.right));
        // 计算当前节点的最大路径和喽
        // 这里需要注意，由于是选择一个路径，所以如果当前节点选择了，那么才能考虑选择左右两个节点，
        // 如果当前节点不选择了，那么只能选择左节点或者右节点，不能同时都选择
        // 三个都选
        int lmr = root.val + left + right;
        // 只选择两个,当前节点的最大值
        int curMax = root.val + Math.max(left, right);
        maxSum = Math.max(maxSum, Math.max(lmr, curMax));
        // 返回当前节点的最大值
        return curMax;
    }

}
