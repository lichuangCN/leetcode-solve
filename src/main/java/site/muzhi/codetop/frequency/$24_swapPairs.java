package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/15
 * 24.两两交换链表中的节点
 */
public class $24_swapPairs {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentry = new ListNode(), prev = sentry, curr = head, next = head.next;
        while (true) {
            ListNode nextHead = next.next;
            // 交换
            next.next = curr;
            prev.next = next;
            prev = curr;
            prev.next = null;

            // 终止条件 1.偶数个 后续没有节点
            if (nextHead == null) {
                break;
            }
            // 终止条件 2.奇数个 后续有一个节点
            if (nextHead.next == null) {
                prev.next = nextHead;
                break;
            }
            // 下一轮
            curr = nextHead;
            next = nextHead.next;
        }
        return sentry.next;
    }
}
