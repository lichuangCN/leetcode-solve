package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/27
 * 25.K个一组翻转链表
 */
public class $25_reverseKGroup {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentry = new ListNode(), prev = sentry, end = sentry;
        sentry.next = head;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 遍历结束 或 未满足后续翻转长度
            if (end == null) {
                break;
            }
            // rHead 当前要反转的链表 subHead 后续链表
            ListNode rHead = prev.next, subHead = end.next;
            // 截断
            end.next = null;
            // 翻转
            prev.next = reverse(rHead);

            // 翻转后的头结点变成尾结点
            prev = rHead;
            // 拼接翻转后的链表和后续链表
            rHead.next = subHead;
            end = rHead;
        }
        return sentry.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode sentry = new ListNode();
        while (head != null) {
            ListNode next = sentry.next;
            sentry.next = head;
            head = head.next;
            sentry.next.next = next;
        }
        return sentry.next;
    }

}
