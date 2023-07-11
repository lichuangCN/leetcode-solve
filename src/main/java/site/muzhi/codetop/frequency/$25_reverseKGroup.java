package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/10
 * 25.K个一组翻转链表
 */
public class $25_reverseKGroup {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentry = new ListNode(), pre = sentry, end = sentry;
        sentry.next = head;
        // end.next == null 表明整个链表已经遍历完毕
        while (end.next != null) {
            // 1.分段
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 不够翻转长度
            if (end == null) {
                break;
            }
            // start 指向当前片段的头结点,翻转后指向最后一个节点
            // next 下一个片段的头结点
            ListNode start = pre.next, next = end.next;

            // 2.分隔两个片段 用于翻转当前片段
            end.next = null;
            pre.next = reverse(start);

            // 重新连接两个片段
            start.next = next;

            // 3.重置到下一段
            pre = start;
            end = pre;
        }
        return sentry.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = new ListNode(), curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return pre.next;
    }
}
