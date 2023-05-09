package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/05/09
 * 47.二叉树减枝
 */
public class $47_pruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return exist(root) ? root : null;
    }

    private boolean exist(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean left = exist(node.left);
        boolean right = exist(node.right);
        boolean curr = node.val == 1;

        // 减枝
        if (!left) {
            node.left = null;
        }
        if (!right) {
            node.right = null;
        }
        if (left || curr || right) {
            return true;
        }
        return false;
    }

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
