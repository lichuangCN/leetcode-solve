package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/11
 * 206.反转链表
 */
public class $206_reverseList {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
