package site.muzhi.cla.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 */
public class $2_removeNthFromEnd {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode fast = head;
        while (--n > 0) {
            fast = fast.next;
        }

        ListNode curr = head,pre = null;

        while (fast.next != null) {
            fast = fast.next;
            pre = curr;
            curr = curr.next;
        }
        if (pre == null) {
            return curr.next;
        }
        pre.next = curr.next;

        return head;
    }
}
