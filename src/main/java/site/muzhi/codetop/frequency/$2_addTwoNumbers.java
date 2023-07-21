package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/20
 * 2.两数相加
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
        ListNode sentry = new ListNode(), tail = sentry;
        int add = 0;
        while (l1 != null || l2 != null) {
            int sum, val;
            if (l1 != null && l2 != null) {
                sum = add + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = add + l1.val;
                l1 = l1.next;
            } else {
                sum = add + l2.val;
                l2 = l2.next;
            }
            add = sum / 10;
            val = sum % 10;
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        if (add != 0) {
            tail.next = new ListNode(add);
        }
        return sentry.next;
    }
}
