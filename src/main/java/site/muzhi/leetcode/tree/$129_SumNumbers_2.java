package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/10/29
 * @description
 */
public class $129_SumNumbers_2 {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        count(0, root);
        return sum;
    }

    private void count(int num, TreeNode node) {
        if (node == null) {
            return;
        }
        int val = num * 10 + node.val;
        // 当前节点是叶子节点
        if (node.left == null && node.right == null) {
            sum += val;
        }
        count(val, node.right);
        count(val, node.left);
    }
}
