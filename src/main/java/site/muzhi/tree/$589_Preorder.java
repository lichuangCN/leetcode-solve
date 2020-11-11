package site.muzhi.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/11/11
 * @description N叉树的后序遍历
 */
public class $589_Preorder {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traversal(res, root);
        return res;
    }

    private void traversal(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children == null || node.children.size() == 0) {
            return;
        }
        List<Node> children = node.children;
        for (Node child : children) {
            traversal(list, child);
        }
    }
}
