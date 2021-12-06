package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/09/25
 * @description 二叉搜索树的第k大节点
 */
public class $54_KthLargest {
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
    }

    private int val = 0, k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        antiInOrder(root);
        return val;
    }

    /**
     * 逆中序遍历查询
     * @param node
     */
    private void antiInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        antiInOrder(node.right);
        if (k == 0) {
            return;
        }
        if ((--k) == 0) {
            val = node.val;
            return;
        }
        antiInOrder(node.left);
    }
}