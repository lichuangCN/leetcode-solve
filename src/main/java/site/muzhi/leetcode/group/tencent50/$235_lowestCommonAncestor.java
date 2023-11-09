package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
 * 235.二叉搜索树的最近公共祖先
 */
public class $235_lowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 终止条件
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
