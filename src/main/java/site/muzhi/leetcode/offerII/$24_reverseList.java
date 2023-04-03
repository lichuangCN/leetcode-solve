package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/04/03
 * 24.翻转链表
 */
public class $24_reverseList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 头插入法
     */
    public ListNode reverseList_2(ListNode head) {
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
