package site.muzhi.leetcode.main;

import java.util.List;

/**
 * @author lichuang
 * @date 2020/11/11
 * @description N叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class $559_MaxDepth {

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

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        List<Node> children = root.children;
        int maxDepth = Integer.MIN_VALUE;
        // 遍历子节点
        for (Node child : children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }

}
