package site.muzhi.leetcode.group.tencent50;

import java.util.List;

/**
 * @author lichuang
 * @date 2023/11/08
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
        ListNode la = headA, lb = headB;
        while (la != lb) {
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;
        }
        return la;
    }
}
