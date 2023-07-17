package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/17
 * 19.删除链表的倒数第N个节点
 */
public class $19_removeNthFromEnd {

    class ListNode {
        int val;
        ListNode next;
    }

    // 输入：head = [1,2,3,4,5], n = 2
    // 输出：[1,2,3,5]
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head, slow = head, prev = null;
        while (--n > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            return head.next;
        }
        prev.next = slow.next;
        return head;
    }
}
