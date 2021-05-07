package site.muzhi.cla.interview.chapter6;

/**
 * @author lichuang
 * @date 2021/05/07
 * @description 二叉树的最近公共祖先
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xas5th/
 */
public class $2_lowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        return null;
    }

}
