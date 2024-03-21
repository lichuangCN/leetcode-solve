package site.muzhi.codetop.bytedance;

/**
 * @author lichuang
 * @date 2024/03/20
 * 25.K个一组翻转链表
 */
public class $25_reverseKGroup {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode start = head, end = head, prev = null;
        for (int i = 0; i < k; i++) {
            // 不足k个节点,直接返回
            if (end == null) {
                return head;
            }
            prev = end;
            end = end.next;
        }
        // 截断链表
        prev.next = null;

        // 递归翻转后面的链表
        ListNode newHead = reverse(head);

        // 原链表的头节点变成翻转后的尾结点
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        ListNode sentry = new ListNode(), curr = head;
        while (curr != null) {
            ListNode next = sentry.next;
            sentry.next = curr;
            curr = curr.next;
            sentry.next.next = next;
        }
        return sentry.next;
    }

}
