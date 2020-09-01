package site.muzhi.tree;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/09/01
 * @description 左叶子之和
 */
public class $404_SumOfLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }

}
