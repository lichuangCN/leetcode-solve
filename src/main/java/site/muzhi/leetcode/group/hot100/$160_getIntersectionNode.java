package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/12
 * 160.相交链表
 */
public class $160_getIntersectionNode {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }
}
