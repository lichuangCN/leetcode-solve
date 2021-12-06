package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/12
 * @description 合并两个有序链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class $25_MergeTwoLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tempHead = new ListNode(0);
        ListNode tail = tempHead;
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
        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return tempHead.next;
    }
}
