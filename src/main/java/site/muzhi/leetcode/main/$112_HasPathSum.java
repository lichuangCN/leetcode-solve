package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/08/25
 * @description 路径总和
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class $112_HasPathSum {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return count(root, 0, sum);
    }

    /**
     * DFS遍历
     * 通过累加路径节点和，计算是否与目标值相同判断
     *
     * @param node
     * @param cur
     * @param sum
     * @return
     */
    public boolean count(TreeNode node, int cur, int sum) {
        if (node == null) {
            return false;
        }
        cur += node.val;
        if (node.left == null && node.right == null) {
            return cur == sum;
        }

        return count(node.left, cur, sum) || count(node.right, cur, sum);
    }
}
