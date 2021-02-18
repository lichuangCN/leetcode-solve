package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description
 */
public class $02_07_GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = (ptrA == null ? headB : ptrA.next);
            ptrB = (ptrB == null ? headA : ptrB.next);
        }
        return ptrA;
    }
}
