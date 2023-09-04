package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 783. 二叉搜索树节点最小距离
 * <p>
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>
 * 中序遍历，求前后元素之间的差值的最小值
 */
public class $783_MinDiffInBST {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int min = Integer.MAX_VALUE, pre = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        minTravel(root);
        return min;
    }

    private void diff(Integer cur) {
        if (pre == Integer.MAX_VALUE) {
            pre = cur;
        } else {
            min = Math.min(min, cur - pre);
            pre = cur;
        }
    }

    private void minTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        minTravel(root.left);
        diff(root.val);
        minTravel(root.right);
    }
}
