package site.muzhi.cla.primaryalgorithm.chapter4;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description 二叉树的最大深度
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 */
public class $1_maxDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = maxDepth(root.left);
        int rightHigh = maxDepth(root.right);
        return Math.max(leftHigh, rightHigh) + 1;
    }
}
