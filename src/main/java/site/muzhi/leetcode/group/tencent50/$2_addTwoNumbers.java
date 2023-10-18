package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/18
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
        int add = 0, sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + add;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + add;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + add;
                l1 = l1.next;
            }
            add = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        if (add != 0) {
            tail.next = new ListNode(add);
        }
        return sentry.next;
    }
}
