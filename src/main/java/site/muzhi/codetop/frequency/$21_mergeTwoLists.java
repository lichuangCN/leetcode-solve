package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/11
 * 21.合并两个有序链表
 */
public class $21_mergeTwoLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode sentry = new ListNode(), tail = sentry;
        while (list1 != null || list2 != null) {
            // 均非空
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                // list1非空 list2已空
                tail.next = list1;
                list1 = list1.next;
            } else {
                // list1已空 list2非空
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return sentry.next;
    }
}
