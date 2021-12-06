package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description 链表求和
 */
public class $02_05_AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0), tail = head;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            add = sum / 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return head.next;
    }
}
