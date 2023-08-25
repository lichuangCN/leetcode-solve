package site.muzhi.leetcode.group.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/02/23
 * @description 剑指 Offer 35. 复杂链表的复制
 * <p>
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class $35_CopyRandomList {

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
            return null;
        }
        // <老节点,新节点>
        Map<Node, Node> map = new HashMap<>();
        Node h = head, dumpy = new Node(0), tail = dumpy;
        while (h != null) {
            Node node = new Node(h.val);
            map.put(h, node);
            tail.next = node;
            h = h.next;
            tail = tail.next;
        }

        Node curr = dumpy.next;
        h = head;
        while (h != null) {
            Node random = map.get(h.random);
            curr.random = random;
            h = h.next;
            curr = curr.next;
        }

        return dumpy.next;
    }
}
