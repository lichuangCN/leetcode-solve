package site.muzhi.codetop.microsoft;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/01/04
 */
public class $234_isPalindrome {
    class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode halfHead = slow;
        // 奇数个元素
        if (fast != null) {
            halfHead = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != halfHead.val) {
                return false;
            }
            halfHead = halfHead.next;
        }
        return true;
    }
}
