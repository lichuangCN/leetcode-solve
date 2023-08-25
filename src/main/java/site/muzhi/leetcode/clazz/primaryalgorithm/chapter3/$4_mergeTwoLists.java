package site.muzhi.leetcode.clazz.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 */
public class $4_mergeTwoLists {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dumpy = new ListNode(), tail = dumpy;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;

            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dumpy.next;
    }
}
