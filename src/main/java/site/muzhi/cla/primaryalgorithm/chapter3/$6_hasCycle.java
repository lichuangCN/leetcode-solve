package site.muzhi.cla.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description 环形链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 */
public class $6_hasCycle {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
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
