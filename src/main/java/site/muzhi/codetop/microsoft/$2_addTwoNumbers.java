package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/16
 */
public class $2_addTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

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
        ListNode sentry = new ListNode(0), tail = sentry;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            add = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + add;
            add = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + add;
            add = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l2 = l2.next;
        }
        if (add > 0) {
            tail.next = new ListNode(add);
        }
        return sentry.next;
    }
}
