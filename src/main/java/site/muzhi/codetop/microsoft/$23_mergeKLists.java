package site.muzhi.codetop.microsoft;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2022/12/07
 * @description
 */
public class $23_mergeKLists {

    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 优先级队列
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        // 将所有队列的头结点添加到优先级队列中
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode sentry = new ListNode(), tail = sentry;
        // 构建结果队列
        while (!queue.isEmpty()) {
            // 取出当前最小值
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            // 当前列表还有值，添加入队列
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return sentry.next;
    }
}
