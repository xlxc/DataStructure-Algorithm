package utils;

/**
 * @author: xuejing
 * @date: 2020/12/09 10:24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + val + ",");
        ListNode head = next;
        while (head != null) {
            sb.append(head.val + ",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
