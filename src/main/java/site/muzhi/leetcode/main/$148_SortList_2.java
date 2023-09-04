package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/09/13
 * @description 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 */
public class $148_SortList_2 {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        for (int i = 1; i < len; i <<= 1) {
            ListNode curr = temp.next;
            ListNode tail = temp;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = cut(left, i);
                // 再一次cut是截取合并的第二个链表
                curr = cut(right, i);
                // 此时left和right都已经是独立的两段链表
                tail.next = merge(left, right);
                // 指向已经合并后的链表的尾结点
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return temp.next;
    }

    /**
     * 截取链表，并返回右侧链表的第一个节点
     *
     * @param head
     * @param len
     * @return
     */
    private ListNode cut(ListNode head, int len) {
        if (head == null) {
            return null;
        }
        for (int i = 1; i < len && head.next != null; i++) {
            head = head.next;
        }

        ListNode rightHead = head.next;
        head.next = null;
        return rightHead;
    }

    /**
     * 迭代合并两个链表
     *
     * @param L1
     * @param L2
     * @return
     */
    private ListNode merge(ListNode L1, ListNode L2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                tail.next = L1;
                L1 = L1.next;
                tail = tail.next;
            } else {
                tail.next = L2;
                L2 = L2.next;
                tail = tail.next;
            }
        }
        tail.next = (L1 == null) ? L2 : L1;
        return head.next;
    }
}
