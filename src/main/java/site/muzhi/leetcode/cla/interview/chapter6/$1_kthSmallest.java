package site.muzhi.leetcode.cla.interview.chapter6;

/**
 * @author lichuang
 * @date 2021/05/07
 * @description 二叉搜索树中第K小的元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xazo8d/
 */
public class $1_kthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int k, val;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        this.k = k;
        track(root);
        return val;
    }

    private void track(TreeNode node) {
        if (node == null) {
            return;
        }
        track(node.left);
        if (--k == 0) {
            val = node.val;
            return;
        }
        track(node.right);
    }
}
