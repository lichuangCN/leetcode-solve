package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 83.删除排序链表中的重复元素
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

        ListNode sentry = new ListNode(), prev = head, curr = head.next;
        sentry.next = head;
        while (curr != null) {
            // 重复元素
            while (curr != null && curr.val == prev.val) curr = curr.next;
            prev.next = curr;
            prev = curr;
            if (curr == null) {
                break;
            }
            curr = curr.next;
        }
        return sentry.next;
    }
}
