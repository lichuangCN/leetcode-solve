package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/09
 * 83.删除链表中的重复元素
 */
public class $83_deleteDuplicates {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head,next = head.next;
        while (true) {
            if (next == null || next.val != curr.val) {
                curr.next = next;
                curr = next;
            }
            if (next == null) {
                return head;
            }
            next = next.next;
        }
    }
}
