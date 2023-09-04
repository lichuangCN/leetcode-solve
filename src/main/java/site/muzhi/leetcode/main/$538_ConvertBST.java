package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/09/21
 * @description 给定一个二叉搜索树（Binary Search Tree），
 * <p>
 * 把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class $538_ConvertBST {

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

    private int val;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        traversal(root);
        return root;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.right);
        val += node.val;
        node.val = val;
        traversal(node.left);
    }
}
