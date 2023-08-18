package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/08/18
 * 2.两数相加（链表）
 */
public class $2_addTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode sentry = new ListNode(), tail = sentry;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + add;
            tail.next = new ListNode(sum % 10);

            tail = tail.next;
            add = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return sentry.next;
    }
}
