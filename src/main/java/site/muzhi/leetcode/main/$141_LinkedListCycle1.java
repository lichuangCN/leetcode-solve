package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/03/02
 * @description: 给定一个链表，判断链表中是否有环。
 */
public class $141_LinkedListCycle1 {

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

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            // 快指针走完链表，链表中不存在环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 快指针走两位
            fast = (fast.next.next == null) ? null : fast.next.next;
            // 慢指针走一位
            slow = (slow.next == null) ? null : slow.next;
            if (fast == slow) {
                // 快慢指针相遇，表明存在环
                break;
            }
        }
        return true;
    }
}
