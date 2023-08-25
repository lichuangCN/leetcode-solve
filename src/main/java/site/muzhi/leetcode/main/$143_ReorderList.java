package site.muzhi.leetcode.list;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/10/20
 * @description 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class $143_ReorderList {

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
     * 通过翻转链表
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 寻找中间节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数节点时slow指向中间节点，偶数节点时指向前半截最后一个节点
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        // 翻转后半截链表
        // 逆置链表的头指针
        ListNode reverseSecond = null;
        while (second != null) {
            // 1. 临时变量存储链表头结点
            ListNode h = second;
            // 2. 头指针后移
            second = second.next;
            // 3. 新的链表的头指针向后移指向当前头节点
            h.next = reverseSecond;
            reverseSecond = h;
        }
        //交叉合并两个链表
        ListNode temp1;
        ListNode temp2;
        while (first != null && reverseSecond != null){
            temp1 = first.next;
            temp2 = reverseSecond.next;

            first.next = reverseSecond;
            first = temp1;

            reverseSecond.next = first;
            reverseSecond = temp2;
        }
    }

    /**
     * 通过队列方式
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> queue = new LinkedList<>();
        // 将所有节点存入到一个双端队列中
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        ListNode tempHead = new ListNode(0), tail = tempHead;
        while (queue.size() > 1) {
            ListNode node1 = queue.pollFirst();
            ListNode node2 = queue.pollLast();
            node1.next = node2;
            tail.next = node1;
            tail = node2;
        }
        if (queue.size() == 1) {
            ListNode node = queue.pollFirst();
            tail.next = node;
            tail = node;
        }
        // 清除尾节点的next指向，避免出现环
        tail.next = null;
        head = tempHead.next;
    }
}
