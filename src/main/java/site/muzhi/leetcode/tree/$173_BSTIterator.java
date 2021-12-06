package site.muzhi.leetcode.tree;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/08/31
 * @description 二叉搜索树迭代器
 */
public class $173_BSTIterator {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIterator {

        private LinkedList<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            TreeNode node = root;
            // 初始化
            if (node != null) {
                stack.addFirst(node);
                while (node.left != null) {
                    stack.addFirst(node.left);
                    node = node.left;
                }
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (hasNext()) {
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

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return stack.size() == 0 ? false : true;
        }
    }
}
