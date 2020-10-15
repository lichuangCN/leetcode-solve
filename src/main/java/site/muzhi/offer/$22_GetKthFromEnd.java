package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/15
 * @description 链表中倒数第k个节点
 */
public class $22_GetKthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        // 提前移动到第k个位置
        while (--k != 0) {
            ptr = ptr.next;
            if (ptr == null) {
                return null;
            }
        }
        ListNode tar = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            tar = tar.next;
        }
        return tar;

    }
}
