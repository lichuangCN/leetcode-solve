package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/29
 * @description 543. 二叉树的直径
 */
public class $543_diameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        treeHeight(root);
        return max;
    }

    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
