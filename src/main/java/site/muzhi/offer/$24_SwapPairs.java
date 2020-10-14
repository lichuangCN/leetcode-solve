package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/13
 * @description 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class $24_SwapPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;
        tail.next = head;
        // 步长为2
        while (tail.next != null && tail.next.next != null) {
            ListNode p = tail.next;
            ListNode q = tail.next.next;
            tail.next = q;
            p.next = q.next;
            q.next = p;
            tail = p;
        }
        return tempHead.next;

    }
}
