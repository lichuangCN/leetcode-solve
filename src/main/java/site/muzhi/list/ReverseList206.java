package site.muzhi.list;

/**
 * @author: LiChuang
 * @date: 2020/02/08
 * @description: 反转一个单链表。不使用额外的空间
 * <p>
 * 算法思想：
 * 1.需要临时变量next存放head.next指针
 * 2.依次向后遍历，并且将head所指向节点的指针指向newHead节点完成倒置
 */
public class ReverseList206 {

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

    public static ListNode reverseList(ListNode head) {
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
