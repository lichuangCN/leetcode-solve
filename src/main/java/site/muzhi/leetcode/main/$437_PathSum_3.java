package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/11/05
 * @description 路径总和 III
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class $437_PathSum_3 {

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

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode node, int pathSum, int sum) {
        if (node == null) {
            return 0;
        }
        pathSum += node.val;
        return (sum == pathSum ? 1 : 0) + helper(node.left, pathSum, sum) + helper(node.right, pathSum, sum);
    }
}
