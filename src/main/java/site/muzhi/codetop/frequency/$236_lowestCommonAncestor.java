package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/13
 * 236.二叉树的最近公共祖先
 */
public class $236_lowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // root节点两侧
        if (left != null && right != null) {
            return root;
        }
        // root节点左侧
        if (left != null) {
            return left;
        }
        // root节点右侧
        if (right != null) {
            return right;
        }
        return null;
    }
}
