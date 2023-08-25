package site.muzhi.leetcode.clazz.primaryalgorithm.chapter4;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description 对称二叉树
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 */
public class $3_isSymmetric {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
