package site.muzhi.leetcode.cla.primaryalgorithm.chapter4;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description 验证二叉搜索树
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 */
public class $2_isValidBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isValidBST(TreeNode root) {
        return track(root,null,null);
    }

    public boolean track(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        boolean left = track(node.left, min, node.val);
        boolean right = track(node.right, node.val, max);
        return left && right;
    }
}
