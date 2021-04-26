package site.muzhi.cla.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 反转链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xavip3/
 */
public class $5_reverseList {

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

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // 在反转后，head.next指针指向新链表的最后一个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumpy = new ListNode(), ptr = head;
        while (ptr != null) {
            ListNode next = dumpy.next;
            dumpy.next = ptr;
            ptr = ptr.next;
            dumpy.next.next = next;
        }
        return dumpy.next;
    }
}
