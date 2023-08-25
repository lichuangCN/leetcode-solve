package site.muzhi.leetcode.clazz.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/25
 * @description 排序链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa262d/
 * <p>
 * 归并排序
 */
public class $3_sortList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 将链表拆成两段
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // 分为两节
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        if (L1.val <= L2.val) {
            L1.next = merge(L1.next, L2);
            return L1;
        } else {
            L2.next = merge(L1, L2.next);
            return L2;
        }
    }

}
