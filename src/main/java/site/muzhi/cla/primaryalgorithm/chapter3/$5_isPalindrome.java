package site.muzhi.cla.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description 回文链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 */
public class $5_isPalindrome {


    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // 1.反转链表
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数个
        if (fast != null) {
            // 后半段的头结点
            slow = slow.next;
        }

        // 1.1 反转后半段链表
        ListNode half = new ListNode();
        while (slow != null) {
            ListNode nextList = half.next;
            half.next = slow;
            slow = slow.next;
            half.next.next = nextList;
        }
        half = half.next;

        // 2.比对
        while (half != null) {
            if (head.val != half.val) {
                return false;
            }
            half = half.next;
            head = head.next;
        }

        return true;
    }
}
