package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/27
 * @description 二叉搜索树的最近公共祖先
 */
public class $68_LowestCommonAncestor_1 {

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
        // 两个节点相同
        if (root == p || root == q) {
            return root;
        }
        // 当前节点大于两个节点，表示公共节点在root节点的左侧
        if ((root.val > p.val) && (root.val > q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if ((root.val < p.val) && (root.val < q.val)) {
            // 在root节点的右侧
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // p,q节点刚好在root两侧
            return root;
        }
    }
}
