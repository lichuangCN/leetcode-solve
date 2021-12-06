package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/09/26
 * @description 二叉树深度
 * <p>
 * 输入一棵二叉树的根节点，
 * 求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class $55_MaxDepth_1 {

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


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
