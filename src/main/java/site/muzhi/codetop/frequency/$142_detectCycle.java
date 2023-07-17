package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/17
 * 142.环形链表
 */
public class $142_detectCycle {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            // 无环
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            // 初始 fast == slow == head, 故需要在最后判定
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
