package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/06
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
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
