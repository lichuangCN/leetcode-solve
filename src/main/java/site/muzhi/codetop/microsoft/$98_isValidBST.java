package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/26
 * @description 98. 验证二叉搜索树
 */
public class $98_isValidBST {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 中序遍历 左 根 右
     */
    // 前置结点的值
    Integer pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 左子树不满足
        if (!isValidBST(root.left)) {
            return false;
        }

        // 当前节点<=前置节点
        if (pre != null && root.val <= pre) {
            return false;
        }
        // 更新前置结点的值
        pre = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBST_2(TreeNode root) {
        return travel(root, null, null);
    }

    /**
     * 递归，逐个节点判断
     */
    private boolean travel(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        // 当前结点
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        // 判断 左子树的最大值 <= 当前节点 右子树的最小值 >= 当前节点
        return travel(node.left, min, node.val) && travel(node.right, node.val, max);
    }
}
