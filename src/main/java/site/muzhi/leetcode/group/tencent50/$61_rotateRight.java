package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/07
 * 61.旋转链表
 */
public class $61_rotateRight {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int size = 0;
        ListNode ptr = head, tail = null;
        while (ptr != null) {
            size++;
            tail = ptr;
            ptr = ptr.next;
        }

        tail.next = head;
        int mov = size - (k % size);
        ListNode prev = tail, curr = head;
        while (mov-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }
}
