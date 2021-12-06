package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2021/04/27
 * @description 938. 二叉搜索树的范围和
 * <p>
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class $938_RangeSumBST {
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

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        rangeSumBST(root.left, low, high);
        int val = root.val;
        if (low <= val && val <= high) {
            sum += val;
        }
        rangeSumBST(root.right, low, high);
        return sum;
    }
}
