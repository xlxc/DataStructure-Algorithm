package tree;

import utils.TreeNode;

/**
 * @author: xuejing
 * @date: 2020/12/22 9:50
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 */
public class Solution_114 {

    // 具体转换步骤：
    // 1)对于某个节点root，将其左孩子节点放到其右孩子上，左孩子节点置空，
    // 2)若某个节点是父节点的左孩子，就将父节点的右孩子指向他；若
    // 按照题意可知，需要使用前序遍历
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root, new TreeNode(0));
    }

    private void preOrder(TreeNode head, TreeNode prev) {
        // 前序遍历
        if (prev.left == head) {
            prev.left = null;
            prev.right = head;
        }
        prev = head;
        preOrder(head.left,prev);
        preOrder(head.right,prev);
    }

    public static void main(String[] args) {
        String a = "12345";
        System.out.println(a.charAt(4));
    }
}
