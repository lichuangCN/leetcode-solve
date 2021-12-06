package site.muzhi.leetcode.cla.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 相交链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xan8ah/
 */
public class $4_getIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA, B = headB;
        while (true) {
            if (A == B) {
                break;
            }
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }
        return A;
    }
}
