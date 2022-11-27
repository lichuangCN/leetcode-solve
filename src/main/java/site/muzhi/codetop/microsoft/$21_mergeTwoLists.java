package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/27
 * @description 21. 合并两个有序链表
 */
public class $21_mergeTwoLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dumpy = new ListNode(), tail = dumpy;
        ListNode l1 = list1, l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        return dumpy.next;
    }
}
