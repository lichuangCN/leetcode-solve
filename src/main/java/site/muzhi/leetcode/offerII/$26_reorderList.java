package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/04/03
 * 26.重排链表
 */
public class $26_reorderList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 入队
        Deque<ListNode> queue = new ArrayDeque<>();
        while (head != null) {
            queue.addLast(head);
            head = head.next;
        }

        ListNode sentry = new ListNode(), tail = sentry;
        while (!queue.isEmpty()) {
            // 取队首元素
            tail.next = queue.pollFirst();
            tail = tail.next;
            if (!queue.isEmpty()) {
                // 取队尾元素
                tail.next = queue.pollLast();
                tail = tail.next;
            }
        }

        tail.next = null;
        head = sentry.next;
    }
}
