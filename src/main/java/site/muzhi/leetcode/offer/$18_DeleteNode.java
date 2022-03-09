package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/10
 * @description 剑指 Offer 18. 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 * <p>
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class $18_DeleteNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null ) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = null,curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }
}
