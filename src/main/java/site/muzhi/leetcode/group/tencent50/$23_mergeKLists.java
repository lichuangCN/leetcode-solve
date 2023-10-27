package site.muzhi.leetcode.group.tencent50;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/10/27
 * 23.合并k个升序链表
 */
public class $23_mergeKLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        ListNode sentry = new ListNode(), tail = sentry;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return sentry.next;
    }
}
