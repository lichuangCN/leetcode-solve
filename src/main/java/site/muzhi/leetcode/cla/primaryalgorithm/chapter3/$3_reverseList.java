package site.muzhi.leetcode.cla.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description 反转链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 */
public class $3_reverseList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
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
        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;
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
        ListNode dumpy = new ListNode(), curr = head;
        while (curr != null) {
            ListNode nextList = dumpy.next;
            dumpy.next = curr;
            curr = curr.next;
            dumpy.next.next = nextList;
        }

        return dumpy.next;
    }
}
