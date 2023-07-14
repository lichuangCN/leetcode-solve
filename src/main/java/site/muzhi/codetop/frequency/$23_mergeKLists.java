package site.muzhi.codetop.frequency;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/07/14
 * 23.合并k个升序链表
 */
public class $23_mergeKLists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // 小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode sentry = new ListNode(), tail = sentry;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            // 当前链表的后继节点添加到堆中
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return sentry.next;
    }
}
