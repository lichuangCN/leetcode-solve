package site.muzhi.leetcode.group.offerII;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/04/06
 * 28.展平多级双向链表
 */
public class $28_flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node sentry = new Node(), tail = sentry;
        stack.push(head);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            // 入栈 先入栈当前队列，后入栈子队列
            if (curr.next != null) {
                stack.push(curr.next);
            }
            if (curr.child != null) {
                stack.push(curr.child);
            }
            curr.prev = tail;
            tail.next = curr;
            tail = curr;

            // 清空节点关联
            curr.child = null;
            curr.next = null;
        }
        sentry.next.prev = null;
        return sentry.next;
    }
}
