package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/08/20
 * @description 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * 1.节点的左子树只包含小于当前节点的数。
 * 2.节点的右子树只包含大于当前节点的数。
 * 3.所有左子树和右子树自身必须也是二叉搜索树。
 */
public class $98_IsValidBST {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        // 左侧，min针对左侧
        // 当前树的根节点不得大于其上层节点
        if (min != null && root.val <= min) {
            return false;
        }
        // 右侧，max针对右侧
        // 当前树的根节点不得小于其上层节点
        if (max != null && root.val >= max) {
            return false;
        }
        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);
        return left && right;
    }
}
