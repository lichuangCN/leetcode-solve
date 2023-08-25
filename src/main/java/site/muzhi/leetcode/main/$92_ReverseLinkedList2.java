package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/02/08
 * @description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。不申请额外的空间
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class $92_ReverseLinkedList2 {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 调整链表的长度
        int changeLen = n - m + 1;
        // 默认返回的链表的头节点为head
        ListNode result = head;
        // 指向翻转链表段的前一个节点指针
        ListNode proNode = null;
        // 寻找第m个节点的一个节点,即第m-1个节点
        while (head != null && (--m > 0)) {
            proNode = head;
            head = head.next;
        }
        // 指向链表反转后的尾节点
        // 注意：此处不能够为proNode.next，当从链表第一个节点开始翻转时，proNode为null
        ListNode tail = head;
        // 翻转后链表的头结点
        ListNode newHead = null;
        // 翻转中间节点
        while (changeLen > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            changeLen--;
        }
        // 调整中间链表的指针
        tail.next = head;
        if (proNode == null) {
            // 如果从第一个几点开始翻转,则头结点应该为翻转链表的头结点
            result = newHead;
        } else {
            // 从中间位置开始翻转
            proNode.next = newHead;
        }
        return result;
    }
}
