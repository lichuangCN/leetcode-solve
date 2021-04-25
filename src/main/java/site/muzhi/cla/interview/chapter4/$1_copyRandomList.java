package site.muzhi.cla.interview.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/04/25
 * @description 复制带随机指针的链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xam1wr/
 */
public class $1_copyRandomList {

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
        // 旧节点和新节点的映射关系
        Map<Node, Node> map = new HashMap<>();
        // 1.构造新链表
        Node h = head, dumpy = new Node(0), tail = dumpy;
        while (h != null) {
            Node node = new Node(h.val);
            tail.next = node;
            map.put(h, node);
            h = h.next;
            tail = tail.next;
        }

        // 2.设置random映射
        Node d = dumpy.next;
        Node t = head;
        while (t != null) {
            Node node = map.get(t.random);
            d.random = node;
            t = t.next;
            d = d.next;
        }
        return dumpy.next;
    }
}
