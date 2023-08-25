package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/10/15
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 *
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
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
