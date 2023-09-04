package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 */
public class $237_DeleteNodeInALinkedList {
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

    /**
     * 所谓删除指定节点，就是讲指定节点的后继节点的值，覆盖给要删除的节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
