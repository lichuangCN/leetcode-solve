package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class $876_MiddleOfTheLinkedList {
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

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果有奇数个节点，slow指向中间节点，否则slow此时指向第二个中间节点
        return slow;
    }
}
