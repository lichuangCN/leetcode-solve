package site.muzhi.leetcode.clazz.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/25
 * @description 环形链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaazns/
 */
public class $2_hasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return true;
    }
}
