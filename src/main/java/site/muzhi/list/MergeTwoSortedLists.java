package site.muzhi.list;

/**
 * Author: lichuang
 * Date: Create in 15:09 2019/11/16
 * Description:
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        // l1
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        // l2
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l21.next = l22;

        ListNode listNode = mergeTwoLists(l11, l21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 非空判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode cursor = head;

        // 合并
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // l1的值小于等于l2
                ListNode node = new ListNode(l1.val);
                cursor.next = node;
                // 指针右移
                l1 = l1.next;
                cursor = cursor.next;
            } else {
                // l1的值大于l2
                ListNode node = new ListNode(l2.val);
                cursor.next = node;
                // 指针右移
                l2 = l2.next;
                cursor = cursor.next;
            }
        }
        // 多出的元素拼接在head链表后面
        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            cursor.next = node;
            // 指针右移
            l1 = l1.next;
            cursor = cursor.next;
        }
        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            cursor.next = node;
            // 指针右移
            l2 = l2.next;
            cursor = cursor.next;
        }
        return head.next;
    }
}
