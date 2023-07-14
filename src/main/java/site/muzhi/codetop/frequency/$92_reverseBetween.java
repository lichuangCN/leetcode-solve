package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/14
 * 92.反转链表 II
 */
public class $92_reverseBetween {

    class ListNode {
        int val;
        ListNode next;
    }

    // 输入：head = [1,2,3,4,5], left = 2, right = 4
    // 输出：[1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // fast 指向翻转区间的后继链表的头结点
        // prev 指向翻转区间的前面链表的尾结点
        // slow 指向翻转区间的头结点
        ListNode slow = head, fast = head, prev = null;

        // 寻找左侧起始节点
        int curr = right - left + 1;
        while (curr-- > 0) {
            fast = fast.next;
        }

        // 寻找翻转区间 本身已经处于第1个位置，故仅需要移动left-1
        curr = left - 1;
        while (curr-- > 0) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        // 翻转链表
        ListNode sentry = new ListNode();
        while (slow != fast) {
            ListNode next = sentry.next;
            sentry.next = slow;
            slow = slow.next;
            sentry.next.next = next;
        }
        if (prev == null) {
            return sentry.next;
        }
        prev.next = sentry.next;
        return head;
    }
}
