package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/06
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
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
    }
}
