package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
 * 142.环形链表 II
 */
public class $142_detectCycle {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (true) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            if (fast == slow) {
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
