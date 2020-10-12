package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/12
 * @description
 */
public class $28_IsSymmetric {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        // 均为null
        if (left == null && right == null) {
            return true;
        }
        // 其中一个是null
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        // 判断当前节点的值以及下一层节点是否满足
        return (left.val == right.val) && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
