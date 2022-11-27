package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/27
 * @description 有环链表
 */
public class $141_hasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while (true) {
            // 终止条件：无环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 终止条件：有环
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
