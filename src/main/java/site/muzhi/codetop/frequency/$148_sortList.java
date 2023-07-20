package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/19
 * 148.排序链表
 */
public class $148_sortList {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 后半截链表
        ListNode halfHead = getHalfHead(head);

        ListNode left = sortList(head);
        ListNode right = sortList(halfHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode sentry = new ListNode(), tail = sentry;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        tail.next = head1 == null ? head2 : head1;
        return sentry.next;
    }

    private ListNode getHalfHead(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 截断链表
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
