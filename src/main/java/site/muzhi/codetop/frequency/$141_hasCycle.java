package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 141.环形链表
 */
public class $141_hasCycle {

    class ListNode {
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while (true) {
            if (slow == fast) {
                return true;
            }
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
    }
}
