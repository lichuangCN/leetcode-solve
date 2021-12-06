package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/08/31
 * @description 求根到叶子节点数字之和
 */
public class $129_SumNumbers {

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

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(0, root);
    }

    public int sum(int num, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            return res;
        }
        return sum(res, node.left) + sum(res, node.right);
    }
}
