package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/09/02
 * @description N叉树的层序遍历
 */
public class $429_LevelOrder {

    /**
     * Definition for a Node.
     */
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

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                // 当前节点的子孩子入队
                if (node.children != null && node.children.size() != 0) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            res.add(level);
        }

        return res;
    }
}
