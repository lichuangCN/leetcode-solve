package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/17
 * 55.二叉搜索树迭代器
 */
public class $55_BSTIterator {

    class BSTIterator {

        Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            TreeNode node = root;

            if (node != null) {
                stack.addFirst(node);
                while (node.left != null) {
                    stack.addFirst(node.left);
                    node = node.left;
                }
            }

        }

        public int next() {
            if (!stack.isEmpty()) {
                TreeNode node = stack.pollFirst();
                int val = node.val;
                if (node.right != null) {
                    stack.addFirst(node.right);
                    node = node.right;
                    while (node.left != null) {
                        stack.addFirst(node.left);
                        node = node.left;
                    }
                }
                return val;
            }
            return 0;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
