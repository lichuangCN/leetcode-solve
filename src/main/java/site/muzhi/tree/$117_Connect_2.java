package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/09/28
 * @description 填充每个节点的下一个右侧节点指针 II(参考116)
 */
public class $117_Connect_2 {


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


    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node currHead = root;
        while (currHead != null) {

            Node currPoint = currHead;
            while (currPoint != null) {
                // 节点的左节点
                if (currPoint.left != null) {
                    // currPoint右侧不为空
                    if (currPoint.right != null) {
                        currPoint.left.next = currPoint.right;
                    } else {
                        // 否则寻找最近的一个节点为next指向
                        currPoint.left.next = getNearestNode(currPoint.next);
                    }
                }
                // 节点的右节点
                if (currPoint.right != null) {
                    currPoint.right.next = getNearestNode(currPoint.next);
                }
                currPoint = currPoint.next;
            }
            // 寻找下一层的头结点
            while (currHead != null) {
                if (currHead.left != null) {
                    currHead = currHead.left;
                    break;
                }
                if (currHead.right != null) {
                    currHead = currHead.right;
                    break;
                }
                currHead = currHead.next;
            }
        }
        return root;
    }

    private Node getNearestNode(Node node) {
        // 寻找node同层的后续节点的子节点
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}
