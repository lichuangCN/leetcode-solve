package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/11
 * 19 删除链表的倒数第K个节点
 */
public class $19_removeNthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        // curr 要移除的节点
        ListNode fast = head, curr = head, pre = null;
        // 因为fast初始为head 故仅需要向后移动 n-1 个单位
        while (--n > 0) {
            fast = fast.next;
        }

        // 向右开始移动
        while (fast.next != null) {
            fast = fast.next;
            pre = curr;
            curr = curr.next;
        }

        // 移除的头结点
        if (pre == null) {
            return curr.next;
        }
        pre.next = curr.next;
        return head;
    }
}
