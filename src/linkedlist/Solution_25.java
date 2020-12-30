package linkedlist;

import utils.ListNode;

import javax.swing.text.DefaultEditorKit;
import java.util.Stack;

/**
 * @author: xuejing
 * @date: 2020/12/15 18:40
 * k个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_25 {

    public static void main(String[] args) {

    }

    // 方法一：使用栈来解决，从左向右遍历链表，如果栈的大小不等于k，就将节点压入栈中
    // 当栈中的大小第一次到达 k 时，说明第一次凑齐了 K 个节点进行逆序，从栈中依次弹出这些节点，并根据弹出的顺序重新连接，这一组逆序完成后
    // 需要记录一下新的头部，同时第一组的最后一个节点（原来是头节点）应该连接下一个节点

    public ListNode reverseKGroup(ListNode head, int k) {
        // k == 1 时，无需翻转
        if (k < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            // 先记录下 cur 的下一个节点
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                // 元素出栈，进行反转

            }

        }
        return null;




    }
}
