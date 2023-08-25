package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/27
 * @description 二叉树的最近公共祖先
 */
public class $68_LowestCommonAncestor_2 {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // 此节点在root两侧
        if (leftNode != null && rightNode != null) {
            return root;
        }
        // 在root右侧
        if (leftNode == null && rightNode != null) {
            return rightNode;
        }
        // 在root左侧
        if (leftNode != null && rightNode == null) {
            return leftNode;
        }
        return null;
    }
}
