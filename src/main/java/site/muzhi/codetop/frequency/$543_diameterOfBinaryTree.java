package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/26
 * 543.二叉树的直径
 */
public class $543_diameterOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        travel(root);
        return max;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = travel(node.left);
        int right = travel(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
