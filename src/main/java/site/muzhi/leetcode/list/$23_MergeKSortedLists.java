package site.muzhi.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: LiChuang
 * @date: 2020/02/19
 * @description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class $23_MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 分治法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        // 创建两个链表数组
        int middle = lists.length / 2;
        ListNode[] list1 = new ListNode[middle];
        for (int i = 0; i < middle; i++) {
            list1[i] = lists[i];
        }
        ListNode[] list2 = new ListNode[lists.length - middle];
        for (int i = middle, j = 0; i < lists.length; i++, j++) {
            list2[j] = lists[i];
        }

        return mergeTwoLists(mergeKLists(list1), mergeKLists(list2));

    }

    /**
     * 递归方法合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    /**
     * 构造最小堆/优先级队列
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        // 优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 临时链表的头结点
        ListNode head = new ListNode(0);
        ListNode temp = head;
        // 将每个链表的第一个节点放入队列
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        // 当队列中存在元素时
        while (queue.size() != 0) {
            // 获取并移除最小的节点
            temp.next = queue.poll();
            temp = temp.next;
            // 如果当前链表有后续节点
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }

        return head.next;
    }
}
