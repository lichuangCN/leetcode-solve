package site.muzhi.leetcode.group.hot100;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/08/22
 * 23.合并k个升序链表
 */
public class $23_mergeKLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        // 初始队列
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        ListNode sentry = new ListNode(), tail = sentry;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return sentry.next;
    }
}
