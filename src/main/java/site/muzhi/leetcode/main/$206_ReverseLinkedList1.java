package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/02/08
 * @description: 反转一个单链表。不使用额外的空间
 * <p>
 * 算法思想：
 * 1.需要临时变量next存放head.next指针
 * 2.依次向后遍历，并且将head所指向节点的指针指向newHead节点完成倒置
 */
public class $206_ReverseLinkedList1 {

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
     * 递归写法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 子链表反转后的头节点
        ListNode newHead = reverseList(head.next);
        // head.next指向的节点时是反转后的子链表的尾结点，即将当前节点添加在翻转链表的尾部
        head.next.next = head;
        // 重置尾部节点的指针为null
        head.next = null;
        return newHead;
    }

    /**
     * 非递归写法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        // 逆置链表的头指针
        ListNode newHead = null;
        while (head != null) {
            // 1. 临时变量存储head.next
            ListNode next = head.next;
            // 2. 将当前head节点的next指针指向newHead
            head.next = newHead;
            // 3. 新的链表的头指针向后移指向当前head节点
            newHead = head;
            // 4. head指针后移
            head = next;
        }
        return newHead;
    }
}
