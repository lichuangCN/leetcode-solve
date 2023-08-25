package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/03/01
 * @description:
 */
public class $61_RotateList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        // 计算链表长，并找到原始链表尾结点
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        // 再移动move个节点，即tail指向新的尾结点
        int move = len - (k % len);
        // 如果刚好移动了n个循环，即位置未发生改动,tail仍指向尾结点
        if (move == 0) {
            return head;
        }
        // 否则拼接为环状链表，寻找移动后的新的链表的头节点head，并且tail也移动成为新链表的尾结点
        tail.next = head;
        while (move > 0) {
            head = head.next;
            tail = tail.next;
            move--;
        }
        // 重置为节点的next指针为null
        tail.next = null;
        return head;
    }
}
