package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2021/04/25
 * @description https://leetcode-cn.com/problems/increasing-order-search-tree/
 * <p>
 * 897. 递增顺序搜索树
 * <p>
 * 中序遍历
 */
public class $897_IncreasingBST {

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

    private TreeNode dumpy = new TreeNode();
    private TreeNode tail = dumpy;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        track(root);
        return dumpy.right;
    }

    public void track(TreeNode root) {
        if (root == null) {
            return;
        }
        track(root.left);
        TreeNode node = new TreeNode(root.val);
        tail.right = node;
        tail = node;
        track(root.right);
    }

}
