package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/08
 * @description 104. 二叉树的最大深度
 */
public class $104_maxDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
