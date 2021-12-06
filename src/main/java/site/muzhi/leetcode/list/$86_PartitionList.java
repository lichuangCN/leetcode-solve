package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/02/15
 * @description: 给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 算法思想：采用两个虚拟头指针表，分别指向数值高/低两个链表，遍历一次链表后再进行拼接
 */
public class $86_PartitionList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 创建两个临时头节点
        ListNode moreHead = new ListNode(0);
        ListNode lessHead = new ListNode(0);
        ListNode moreTail = moreHead;
        ListNode lessTail = lessHead;
        while (head != null) {
            if (head.val < x) {
                // 将当前节点拼接到小数值链表
                lessTail.next = head;
                head = head.next;
                lessTail = lessTail.next;
                lessTail.next = null;
            } else {
                // 将当前节点拼接到高数值链表
                moreTail.next = head;
                head = head.next;
                moreTail = moreTail.next;
                moreTail.next = null;
            }
        }
        // 两个链表进行拼接
        lessTail.next = moreHead.next;
        return lessHead.next;
    }
}
