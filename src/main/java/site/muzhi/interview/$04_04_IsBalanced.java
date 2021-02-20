package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/02/20
 * @description
 */
public class $04_04_IsBalanced {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        treeHigh(root);
        return flag;
    }

    public int treeHigh(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = treeHigh(node.left);
        int rightH = treeHigh(node.right);
        if (Math.abs(leftH - rightH) > 1) {
            flag = false;
        }
        return Math.max(leftH, rightH) + 1;
    }
}
