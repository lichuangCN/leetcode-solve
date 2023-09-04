package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/03/02
 * @description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class $81_RemoveDuplicatesFromSortedList1 {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode cur = tail;
        while (cur != null) {
            while (cur != null && cur.next != null && cur.next.val == tail.val) {
                // 当遇见相同元素
                cur = cur.next;
            }
            // 指向下一个值不相同的元素
            tail.next = cur.next;
            // 调整指向队尾元素
            tail = cur.next;
            // cur指向队尾
            cur = cur.next;
        }
        return head;
    }
}
