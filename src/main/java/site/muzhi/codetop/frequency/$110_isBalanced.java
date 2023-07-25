package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/25
 * 110.平衡二叉树
 */
public class $110_isBalanced {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeHigh(root.left);
        int right = treeHigh(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHigh(root.left);
        int right = treeHigh(root.right);
        return Math.max(left, right) + 1;
    }

}
