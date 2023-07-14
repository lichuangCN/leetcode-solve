package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/14
 * 160.相交链表
 */
public class $160_getIntersectionNode {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        // a b 均非null; a b均为null
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
