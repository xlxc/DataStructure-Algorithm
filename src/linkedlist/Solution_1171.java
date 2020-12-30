package linkedlist;

import utils.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2020/12/30 9:31
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1171 {

    // 思想：先计算数组的前缀和，根据前缀和的规律，我们可以发现当某两个前缀和相等时，说明这两个区间之间的总和值为0
    // 那么就要删除这个区间中的元素，为了方便，我们可以使用 哈希表
    // 哈希表的 key：前缀和，value：节点值

    public ListNode removeZeroSumSublists(ListNode head) {
        // 为了代码的方便，用带头节点的单链表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        // 首次建立哈希表，若同一个出现了多次，在哈希表中则会被覆盖，只记录该 sum 出现的最后一个节点
        int sum = 0;
        // 使用 for 循环遍历单链表
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        // 第二次遍历单链表，同时也要计算一次前缀和sum，如果当前节点处的 sum 在哈希表中出现，说明当前节点到
        // 最后的一个节点，这个区间中的数都需删除
        sum = 0;
        for (ListNode d = dummy; d != null; d= d.next){
            sum += d.val;
            d.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
