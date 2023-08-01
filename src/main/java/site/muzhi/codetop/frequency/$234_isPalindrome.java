package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/08/01
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

        ListNode slow = head, fast = head, prev = null, halfHead = null;
        Stack<ListNode> prevStack = new Stack<>();
        while (fast != null && fast.next != null) {
            prev = slow;
            prevStack.push(prev);
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast == null 元素是偶数, 且slow指向后半截第一个节点
        // fast.next == null 元素是奇数, 且slow指向正中间节点
        prev.next = null;
        if (fast != null && fast.next == null) {
            halfHead = slow.next;
        } else {
            halfHead = slow;
        }

        while (halfHead != null) {
            if (prevStack.pop().val != halfHead.val) {
                return false;
            }
            halfHead = halfHead.next;
        }
        return true;
    }
}
