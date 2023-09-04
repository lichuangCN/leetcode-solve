package site.muzhi.leetcode.main;

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

public class $21_MergeTwoSortedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 创建新的节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

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

    /**
     * 使用原有节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1!=null && l2!=null) {
            if (l1.val<=l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1!=null) {
            temp.next = l1;
        }
        if (l2!=null) {
            temp.next = l2;
        }
        return head.next;
    }
}
