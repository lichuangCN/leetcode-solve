package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description
 */
public class $02_06_IsPalindrome {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 寻找中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast==null表示节点为偶数个，此时slow指向后半段的首节点
        // fast!=null表示节点为奇数个，此时slow指向中间节点
        if (fast != null) {
            // 指向后半段节点的首节点
            slow = slow.next;
        }
        // 反转后半段节点
        ListNode halfHead = new ListNode(0);
        while (slow != null) {
            ListNode next = halfHead.next;
            halfHead.next = slow;
            slow = slow.next;
            // 拼接
            halfHead.next.next = next;
        }
        // 对比
        halfHead = halfHead.next;
        while (halfHead != null) {
            if (halfHead.val != head.val) {
                return false;
            }
            halfHead = halfHead.next;
            head = head.next;
        }
        return true;
    }
}
