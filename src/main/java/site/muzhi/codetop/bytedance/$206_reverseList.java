package site.muzhi.codetop.bytedance;

/**
 * @author lichuang
 * @date 2024/03/21
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
        ListNode sentry = new ListNode(), curr = head;
        while (curr != null) {
            ListNode next = sentry.next;
            sentry.next = curr;
            curr = curr.next;
            sentry.next.next = next;
        }
        return sentry.next;
    }
}
