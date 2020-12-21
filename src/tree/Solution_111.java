package tree;

import jdk.nashorn.internal.runtime.Context;
import utils.TreeNode;

import java.time.chrono.MinguoChronology;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author: xuejing
 * @date: 2020/12/21 9:04
 * 111.二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Solution_111 {

    // 本题有两种解法：BFS 和 DFS

    public int minDepth(TreeNode root) {
        return bfs(root);
    }

    // BFS(广度优先搜索)，BFS使用的是队列
    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;
        // 定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 1.将头节点加入队列中
        queue.offer(root);
        minDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历队列中的所有元素，在从队列中取出某个节点时，同时需要将其左右孩子节点加入队列中
            // 这里循环完后，遍历的只是该层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 如果从队列中取出的当前节点是叶子节点，那么就直接返回了
                // 因为题目要求的是最小的深度
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    // DFS(深度优先搜索)，DFS使用的是栈，一般都是用递归来实现，递归的本质就是栈
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, dfs(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, dfs(root.right));
        }
        return minDepth + 1;
    }
}
