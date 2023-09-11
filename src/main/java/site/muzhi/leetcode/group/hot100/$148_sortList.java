package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/11
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

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode sentry = new ListNode(), tail = sentry;
        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                if (h1.val <= h2.val) {
                    tail.next = h1;
                    h1 = h1.next;
                } else {
                    tail.next = h2;
                    h2 = h2.next;
                }
                tail = tail.next;
            } else if (h1 == null) {
                tail.next = h2;
                break;
            } else {
                tail.next = h1;
                break;
            }
        }
        return sentry.next;
    }

    public ListNode half(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // 切断链表
        prev.next = null;
        return slow;
    }
}
