package site.muzhi.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/08/29
 * @description
 */
public class $116_Connect_1 {

    /**
     * Definition for a Node.
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 空间复杂度为常数O(1)
     *
     * @param root
     * @return
     */
    public Node connect_1(Node root) {

        if (root == null) {
            return null;
        }
        // 第n层左侧节点，当前层已经处理完毕
        Node curr = root;
        // 判断是否到最后一层
        while (curr.left != null) {
            // 遍历当前层的指针
            Node currHead = curr;
            // 处理n+1层
            while (currHead != null) {
                // 1.连接同一节点的左右两个子节点
                currHead.left.next = currHead.right;

                // 2.连接不同节点的两个子节点（右->左）
                if (currHead.next != null) {
                    currHead.right.next = currHead.next.left;
                }
                // 3.移动上层head指针
                currHead = currHead.next;
            }

            // curr指向n+1层
            curr = curr.left;

        }
        return root;
    }

    /**
     * 采用队列，空间复杂度为O(n)
     *
     * @param root
     * @return
     */
    public Node connect_2(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 节点的左右子节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
