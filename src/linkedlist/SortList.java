package linkedlist;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/12/10 20:09
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

    // 最暴力的解法就是 将链表转换成 数组，然后对数组进行排序，
    // 然后将排序后的数组再次转换成链表即可
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode cur = new ListNode(0);
        ListNode res = new ListNode(0);
        res = cur;
        for (Integer integer : list) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return res.next;
    }

    public ListNode sortList1(ListNode head) {
        return null;
    }
}
