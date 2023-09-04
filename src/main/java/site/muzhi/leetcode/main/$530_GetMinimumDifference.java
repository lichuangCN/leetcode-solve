package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/10/12
 * @description 二叉搜索树的最小绝对差
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 */
public class $530_GetMinimumDifference {
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

    private int min = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return 0;
        }
        inOrderTraversal(root);
        return min;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        // 比较
        if(preNode != null) {
            min = Math.min(min,(node.val-preNode.val));
        }
        preNode = node;
        inOrderTraversal(node.right);
    }
}
