package site.muzhi.hot100;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 两数相加
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class $2_addTwoNumbers {
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
        ListNode dumpy = new ListNode(0), tail = dumpy;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            add = sum / 10;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = node;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return dumpy.next;
    }
}
