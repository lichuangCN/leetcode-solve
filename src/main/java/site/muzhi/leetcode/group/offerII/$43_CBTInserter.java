package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/05
 * 43.向完全二叉树添加节点
 */
public class $43_CBTInserter {

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                // 层序遍历，先将当前层节点加入队列
                TreeNode node = queue.peekFirst();
                if (node.left == null) {
                    // 待插入节点的父节点
                    break;
                } else {
                    queue.addLast(node.left);
                }

                if (node.right == null) {
                    // 待插入节点的父节点
                    break;
                } else {
                    queue.addLast(node.right);
                    // 当前节点左右节点均非空，不是待插入节点的父节点
                    queue.pollFirst();
                }
            }
        }

        public int insert(int v) {
            TreeNode parent = queue.peekFirst();
            TreeNode child = new TreeNode(v);
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
                // 当前父节点左右子节点均非空，移除队列
                queue.pollFirst();
            }
            queue.addLast(child);
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
