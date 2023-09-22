package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/22
 * 236.二叉树的最近公共祖先
 */
public class $236_lowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return right == null ? left : right;
    }
}
