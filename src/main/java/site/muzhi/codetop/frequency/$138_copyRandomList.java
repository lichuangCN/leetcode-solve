package site.muzhi.codetop.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2024/01/22
 * 138.随机链表的复制
 */
public class $138_copyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr = head, sentry = new Node(0), tail = sentry;
        while (curr != null) {
            Node node = new Node(curr.val);
            nodeMap.put(curr, node);
            tail.next = node;
            tail = tail.next;
            curr = curr.next;
        }

        // 补充随机指针
        curr = head;
        tail = sentry.next;
        while (curr != null) {
            if (curr.random != null) {
                Node rNode = nodeMap.get(curr.random);
                tail.random = rNode;
            }
            curr = curr.next;
            tail = tail.next;
        }
        return sentry.next;
    }
}
