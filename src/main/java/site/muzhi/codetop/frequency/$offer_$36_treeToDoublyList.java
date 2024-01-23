package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2024/01/23
 * LCR 155 将二叉搜索树转化为排序的双向链表
 */
public class $offer_$36_treeToDoublyList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new ArrayDeque<>();
        travel(queue, root);

        // 构建双向链表
        Node prev = null, curr = null, head = null;
        while (!queue.isEmpty()) {
            curr = queue.pollFirst();
            if (prev == null) {
                // 头节点
                curr.left = null;
                head = curr;
            } else {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
        }
        curr.right = head;
        head.left = curr;


        return head;
    }

    private void travel(Deque<Node> queue, Node root) {
        if (root == null) {
            return;
        }
        travel(queue, root.left);
        queue.add(root);
        travel(queue, root.right);
    }
}
