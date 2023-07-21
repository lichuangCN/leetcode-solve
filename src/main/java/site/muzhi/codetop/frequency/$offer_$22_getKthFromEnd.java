package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/21
 * offer.22.链表中倒数第k个节点
 */
public class $offer_$22_getKthFromEnd {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (--k > 0) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
