package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/10
 * 206.翻转链表
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
        ListNode sentry = new ListNode(), pointer = sentry;
        while (head != null) {
            ListNode next = head.next;
            head.next = pointer.next;
            pointer.next = head;
            head = next;
        }
        return sentry.next;
    }
}
