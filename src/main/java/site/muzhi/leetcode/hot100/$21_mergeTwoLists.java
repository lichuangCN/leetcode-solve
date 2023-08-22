package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/08/22
 * 21.合并两个有序链表
 */
public class $21_mergeTwoLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode sentry = new ListNode(), tail = sentry;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return sentry.next;
    }
}