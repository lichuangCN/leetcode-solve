package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/04/04
 * 29.排序的循环链表
 */
public class $29_insert {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if (head.next == head) {
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            // 非联结位置
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            // 联结位置
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        // 一圈后仍未定位插入位置 或已经定位位置
        Node node = new Node(insertVal);
        curr.next = node;
        node.next = next;
        return head;
    }
}
