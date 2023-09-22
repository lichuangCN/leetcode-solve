package site.muzhi.leetcode.group.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/09/20
 * 234.回文链表
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
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (node != null) {
            if (node.val != stack.pop().val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
