package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/14
 */
public class $236_lowestCommonAncestor {
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

    /**
     * 递归向下寻找：p、q节点位置
     * 1.p、q在root两侧
     * 2.p、q在root左侧
     * 3.p、q在root右侧
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            // 在root节点两侧发现p q
            return root;
        }
        if (left == null && right != null) {
            // root节点左侧未发现 且 root节点右侧发现
            return right;
        }
        if (left != null && right == null) {
            // root节点左侧发现 且 root节点右侧未发现
            return left;
        }
        return null;
    }
}
