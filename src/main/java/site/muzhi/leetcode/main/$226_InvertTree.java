package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/09/01
 * @description 翻转二叉树
 */
public class $226_InvertTree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        // 递归下一层
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
