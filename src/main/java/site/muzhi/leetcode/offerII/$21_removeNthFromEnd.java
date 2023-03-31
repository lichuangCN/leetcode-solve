package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/03/31
 * 删除链表倒数第n个节点
 */
public class $21_removeNthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        // 快指针
        ListNode fast = head;
        while (--n > 0) {
            fast = fast.next;
        }

        // curr:要移除的节点 prev:前置节点
        ListNode curr = head, prev = null;
        // 向右移动
        while (fast.next != null) {
            prev = curr;
            curr = curr.next;
            fast = fast.next;
        }

        // 移除头结点
        if (prev == null) {
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}
