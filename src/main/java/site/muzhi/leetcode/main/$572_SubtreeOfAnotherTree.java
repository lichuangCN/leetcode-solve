package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/05/07
 * @description 给定两个非空二叉树 s 和 t，
 * 检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树
 */

public class $572_SubtreeOfAnotherTree {
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
     * 递归匹配
     *
     * @param s 主树
     * @param t 匹配子树
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        } else {
            // 递归遍历主树的子树
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    /**
     * 递归比较两个子树是否相同
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSame(TreeNode p, TreeNode q) {
        // 两个节点全部为null时，此时结构相同
        if (p == null && q == null) {
            return true;
        }
        // 一个节点为null，一个节点非null
        if (p == null || q == null) {
            return false;
        }
        // 两个节点非null，并且值不同
        if (p.val != q.val) {
            return false;
        } else {
            // 当前节点值相同，比较下一层的节点
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }
    }
}
