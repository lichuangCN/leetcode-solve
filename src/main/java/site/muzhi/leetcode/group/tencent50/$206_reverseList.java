package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
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
        ListNode sentry = new ListNode();
        while (head != null) {
            ListNode next = sentry.next;
            sentry.next = head;
            head = head.next;
            sentry.next.next = next;
        }
        return sentry.next;
    }
}
