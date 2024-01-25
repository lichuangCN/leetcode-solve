package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/25
 * 61.旋转链表
 */
public class $61_rotateRight {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 从head节点开始，向后移动mv个节点 找到新的head节点
        int mv = len - (k % len);

        tail.next = head;
        ListNode prev = tail, nHead = head;
        // 寻找新head节点
        while (mv-- > 0) {
            prev = nHead;
            nHead = nHead.next;
        }
        prev.next = null;
        return nHead;
    }
}
