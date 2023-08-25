package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/11/05
 * @description 二叉树剪枝
 * <p>
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 */
public class $814_PruneTree {

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

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return existOne(root) ? root : null;
    }

    /**
     * 当前树是否存在1
     *
     * @param node
     * @return
     */
    private boolean existOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean mid = (node.val == 1);
        boolean left = existOne(node.left);
        boolean right = existOne(node.right);
        // 剪枝
        if (!left) {
            node.left = null;
        }
        if (!right) {
            node.right = null;
        }
        if (left || mid || right) {
            return true;
        }
        return false;
    }
}
