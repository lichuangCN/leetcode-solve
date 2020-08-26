package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/08/26
 * @description 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class $110_IsBalanced {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 由上向下递归
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        // 根节点两侧子树树高差
        boolean h = Math.abs(left - right) <= 1;

        // 判断左右两个子树是否平衡
        boolean bLeft = isBalanced(root.left);
        boolean bRight = isBalanced(root.right);

        return (h && bLeft && bRight);
    }

    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
