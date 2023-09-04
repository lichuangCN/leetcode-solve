package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/01
 * 98.验证二叉搜索树
 */
public class $98_isValidBST {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return travel(root);
    }

    public boolean travel(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = travel(node.left);
        // 当前节点的值小于前置节点的值
        boolean curr = prev == null ? false : node.val <= prev.val;
        if (!left || curr) {
            return false;
        }
        prev = node;
        return travel(node.right);
    }
}
