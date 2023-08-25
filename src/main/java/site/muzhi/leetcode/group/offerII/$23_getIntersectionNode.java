package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/04/03
 * 23.两个链表的第一个重合节点
 */
public class $23_getIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (true) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
    }
}
