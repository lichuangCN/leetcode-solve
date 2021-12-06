package site.muzhi.leetcode.interview;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/02/20
 * @description 搜索二叉树是否合法
 */
public class $04_05_IsValidBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 中序遍历，递增序列
     *
     * @param root
     * @return
     */
    public boolean isValidBST_1(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        double min = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            TreeNode node = stack.removeLast();
            if (node.val <= min) {
                return false;
            }
            min = node.val;
            root = node.right;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    /**
     * 递归方式
     *
     * @param node
     * @param left
     * @param right
     * @return
     */
    public boolean helper(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (left != null && val <= left) {
            return false;
        }
        if (right != null && val >= right) {
            return false;
        }
        if (!helper(node.left, left, val)) {
            return false;
        }
        if (!helper(node.right, val, right)) {
            return false;
        }
        return true;
    }
}
