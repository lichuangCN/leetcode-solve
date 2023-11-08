package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
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
        ListNode half = half(head);
        return merge(sortList(head), sortList(half));
    }

    private ListNode half(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 截断
        prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(), tail = sentry;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tail.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
            }
            tail = tail.next;
        }
        return sentry.next;
    }
}
