package bfs;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author: xuejing
 * @date: 2020/12/21 20:07
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class Solution_513 {

    // 题目要求输出最后一行最左边的值，刚好可以使用队列吗，一行行的遍历
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
