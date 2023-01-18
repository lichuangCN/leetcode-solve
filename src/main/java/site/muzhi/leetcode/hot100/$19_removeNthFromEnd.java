package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/01/18
 * 19.移除倒数第K个节点
 */
public class $19_removeNthFromEnd {

    class ListNode {
        int val;
        ListNode next;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }

        // curr: 要移除的节点 prev: 要移除节点的前驱节点
        ListNode fast = head, curr = head, prev = null;
        while (--n > 0) {
            fast = fast.next;
        }

        // 开始移动
        while (fast.next != null) {
            fast = fast.next;
            prev = curr;
            curr = curr.next;
        }
        // fast指向尾结点

        // 移除的是头节点
        if (prev == null) {
            return head.next;
        }

        // 移除目标节点
        prev.next = curr.next;
        return head;
    }
}