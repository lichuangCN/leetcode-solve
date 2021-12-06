package site.muzhi.leetcode.tree;

/**
 * @author: lichuang
 * @date: 2020/03/10
 * @description: 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

public class $543_DiameterOfBinaryTree {

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
     * 树的最大宽度
     */
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        treeDepth(root);
        return max;
    }

    /**
     * 计算树的高度
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        // 比较当前节点树的宽度和之前得到的树的宽度
        max = Math.max(left + right, max);
        // 返回当前节点的深度
        return Math.max(left, right) + 1;
    }
}
