package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/02/14
 * @description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 算法思想： 采用快慢指针来解决问题
 */
public class $142_LinkedListCycle2 {
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

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            // 当快指针检测到链表后续为空，表明链表不存在环
            if (fast == null || fast.next == null) {
                return null;
            }
            // 快指针，每次向后移动两位
            fast = (fast.next.next != null) ? fast.next.next : null;
            slow = (slow.next != null) ? slow.next : null;
            // 当快慢指针相遇时，表示链表存在环
            if (fast == slow) {
                break;
            }
        }
        /*
         * 重置快指针指向头结点
         * 此时链表存在环，当快慢指针相遇时，即是环的入口节点
         */
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
