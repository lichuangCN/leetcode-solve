package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/14
 * 226.翻转二叉树
 */
public class $226_invertTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
