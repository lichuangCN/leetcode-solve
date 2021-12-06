package site.muzhi.leetcode.tree;

/**
 * @author: LiChuang
 * @date: 2020/02/27
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * <p>
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class $236_LowestCommonAncestorOfABinaryTree {

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
     * 递归写法
     * <p>
     * 思想：查看当前节点(包含)下是否存在p和q
     * 即探寻p和q的分布情况
     * 1.p和q各在当前节点的左右子树
     * 2.p和q同时在当前节点的左子树或右子树
     * 3.p和q均不在当前节点子树下
     * <p>
     * 时间复杂度 O(n)：可能要遍历所有节点n
     * 空间复杂度 O(n)：可能要递归树高，树高可能为n
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 当找到p或q节点时，返回当前节点的位置
        if (root == p || root == q) {
            return root;
        }
        // 否则继续向下层寻找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p和q分布在root节点的左右两颗子树
        if (left != null && right != null) {
            return root;
        }
        // p和q分布在root节点的右子树上
        if (left == null && right != null) {
            return right;
        }
        // p和q分布在root节点的左子树上
        if (left != null && right == null) {
            return left;
        }
        // 均不存在
        return null;
    }

}
