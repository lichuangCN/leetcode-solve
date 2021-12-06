package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description
 */
public class $02_04_Partition {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lowHead = new ListNode(-1), lowTail = lowHead;
        ListNode highHead = new ListNode(-1), highTail = highHead;
        ListNode ptr = head;
        while (ptr != null) {
            int val = ptr.val;
            if (val < x) {
                lowTail.next = ptr;
                lowTail = lowTail.next;
            } else {
                highTail.next = ptr;
                highTail = highTail.next;
            }
            ptr = ptr.next;
        }
        // 拼接
        highTail.next = null;
        lowTail.next = highHead.next;
        return lowHead.next;
    }

}
