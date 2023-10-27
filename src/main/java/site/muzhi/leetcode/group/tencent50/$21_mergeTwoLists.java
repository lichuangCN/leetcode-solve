package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/25
 * 21.合并两个有序链表
 */
public class $21_mergeTwoLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentry = new ListNode(), tail = sentry;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            } else if (list1 == null) {
                tail.next = list2;
                break;
            } else {
                tail.next = list1;
                break;
            }
        }
        return sentry.next;
    }
}
