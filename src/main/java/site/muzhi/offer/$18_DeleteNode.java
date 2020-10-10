package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/10
 * @description 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
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
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode curr = head, pre = null;
        while (curr != null) {

            if (curr.val != val) {
                pre = curr;
                curr = curr.next;
            } else {
                pre.next = curr.next;
                break;
            }
        }
        return head;
    }
}
