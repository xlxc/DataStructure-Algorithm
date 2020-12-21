package tree;

import jdk.nashorn.internal.runtime.Context;
import utils.ListNode;
import utils.TreeNode;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/12/21 9:30
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class Solution_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<Double> res) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 这里每次遍历的是一层的数据
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add((sum * 1.0) / size);
        }
    }
}
