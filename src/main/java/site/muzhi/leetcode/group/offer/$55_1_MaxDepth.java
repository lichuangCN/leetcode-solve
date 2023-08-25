package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/26
 * @description 剑指 Offer 55 - I. 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，
 * 求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class $55_1_MaxDepth {

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
