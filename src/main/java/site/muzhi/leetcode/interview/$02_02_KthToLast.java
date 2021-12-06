package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/01/29
 * @description 倒数第k个节点
 */
public class $02_02_KthToLast {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {

        ListNode fast = head, slow = head;
        // 提前走k-1个节点
        while ((--k) != 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
