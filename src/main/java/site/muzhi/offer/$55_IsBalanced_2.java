package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/31
 * @description 平衡二叉树
 */
public class $55_IsBalanced_2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        // 左右子树树高差
        boolean h = Math.abs(left - right) <= 1;
        return h & isBalanced(root.left) & isBalanced(root.right);
    }

    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
