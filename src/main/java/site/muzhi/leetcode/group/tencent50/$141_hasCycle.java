package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
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

        ListNode slow = head, fast = head;

        while (true) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow) {
                break;
            }
        }
        return true;
    }
}
