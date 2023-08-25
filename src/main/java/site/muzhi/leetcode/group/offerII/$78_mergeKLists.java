package site.muzhi.leetcode.group.offerII;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/06/15
 * 78.合并排序链表
 */
public class $78_mergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 小顶堆队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            // 阴险的测试用例 null
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode sentry = new ListNode(), tail = sentry;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            // 子队列的下一个元素添加到堆中
            if (node.next != null) {
                queue.offer(node.next);
            }
            // 清空关联
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return sentry.next;
    }
}
