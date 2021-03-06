package leetcodetop500;

import utils.ListNode;

import java.util.PriorityQueue;

/**
 * @author: xuejing
 * @date: 2020/12/18 22:19
 */
public class Solution_23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(3);
        lists[0].next.next = new ListNode(6);

        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(4);
        lists[1].next.next = new ListNode(8);

        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(4);
        lists[2].next.next = new ListNode(5);

        Solution_23 sol = new Solution_23();
        System.out.println(sol.mergeKLists(lists).toString());
    }

    // 合并k个有序链表，可以使用堆来解决
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode curr = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        // 开始比较
        while (!pq.isEmpty()) {
            curr = pq.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}
