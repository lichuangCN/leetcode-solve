package site.muzhi.leetcode.group.offerII;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/04/03
 * 25.链表中的两数相加
 */
public class $25_addTwoNumbers {

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
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode sentry = new ListNode();
        int add = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || add != 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + add;
            int val = sum % 10;
            add = sum / 10;
            ListNode next = sentry.next;
            sentry.next = new ListNode(val);
            sentry.next.next = next;
        }
        return sentry.next;

    }
}
