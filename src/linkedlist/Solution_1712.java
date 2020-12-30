package linkedlist;

import sun.security.krb5.Config;
import utils.TreeNode;

import java.security.cert.PKIXRevocationChecker;
import java.util.function.Predicate;

/**
 * @author: xuejing
 * @date: 2020/12/17 9:13
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1712 {

    // 如何将二叉搜索树转换成单链表，并且要求转换后的单链表也是递增有序的
    // 我们知道，中序遍历二叉搜索树可以得到一个递增的序列，那么如果我们在遍历的过程中，
    // 修改每一个根节点的左右指针的指向，不就可以实现单链表了吗，那么如果更新指针的指向呢？
    // 在中序遍历过程中，将当前节点的左指针置空，并将当前节点置为上一个节点的右边节点
    //  (相当于左指针一直都是空的，而右指针就相当于是 next 指针)
    // 由于要获得当前节点的上一个节点，所以设置 pre 指针始终指向当前节点的上一结点，在遍历时不断的移动。


    // 为了返回单向链表的头节点而多设的一个节点
    // 指向当前节点的前一个节点
    private TreeNode head = new TreeNode();
    private TreeNode prev = null;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        System.out.println(prev.left);

        prev = head;
        // 中序遍历
        dfs(root);
        return head.right;
    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历
        dfs(root.left);
        root.left = null;
        prev.right = root;
        prev = root;
        dfs(root.right);
    }

}
