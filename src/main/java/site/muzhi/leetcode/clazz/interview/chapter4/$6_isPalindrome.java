package site.muzhi.leetcode.clazz.interview.chapter4;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 回文链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaw0rm/
 */
public class $6_isPalindrome {

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
     * 翻转后半截链表
     * 因为是在原链表上进行操作，即空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast!=null,此时链表个数是奇数，并且slow指向中间节点
        if (fast != null) {
            // 后半截链表
            slow = slow.next;
        }

        // 翻转后半截链表
        ListNode dumpy = new ListNode(), ptr = slow;
        while (ptr != null) {
            ListNode next = dumpy.next;
            dumpy.next = ptr;
            ptr = ptr.next;
            dumpy.next.next = next;
        }
        ListNode halfHead = dumpy.next;
        while (halfHead != null) {
            if (head.val != halfHead.val) {
                return false;
            }
            head = head.next;
            halfHead = halfHead.next;
        }

        return true;
    }

    /**
     * 借助栈来缓存前半部分的元素
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome_1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast!=null,此时链表个数是奇数，并且slow指向中间节点
        if (fast != null) {
            // 后半截链表
            slow = slow.next;
        }
        // 由中间向两侧比较节点值
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
