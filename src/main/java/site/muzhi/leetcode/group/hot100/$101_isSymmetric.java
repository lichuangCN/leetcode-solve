package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/01
 * 101.对称二叉树
 */
public class $101_isSymmetric {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return travel(root.left, root.right);
    }

    private boolean travel(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || right.val != left.val) {
            return false;
        }
        return travel(left.left, right.right) && travel(left.right, right.left);
    }
}
