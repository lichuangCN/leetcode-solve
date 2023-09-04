package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/06/24
 * @description 965. 单值二叉树
 * <p>
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
public class $965_IsUnivalTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return travel(root, root.val);
    }

    /**
     * 前序遍历，如果出现第二值，直接返回
     *
     * @param node
     * @param val
     * @return
     */
    public boolean travel(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (val != node.val) {
            return false;
        }
        return travel(node.left, val) && travel(node.right, val);
    }
}
