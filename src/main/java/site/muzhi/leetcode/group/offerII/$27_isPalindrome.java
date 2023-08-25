package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/04/04
 * 27.回文链表
 */
public class $27_isPalindrome {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        while (head != null) {
            queue.addLast(head.val);
            head = head.next;
        }
        while (!queue.isEmpty()) {
            Integer left = queue.pollFirst();
            if (!queue.isEmpty()) {
                Integer right = queue.pollLast();
                if (!left.equals(right)) {
                    return false;
                }
            }
        }
        return true;
    }
}
