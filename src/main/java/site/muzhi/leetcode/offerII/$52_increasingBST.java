package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/05/12
 * 51.展开二叉搜索树
 */
public class $52_increasingBST {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(), ptr = newRoot;

        // 中序遍历
        travel(root, ptr);
        return newRoot.right;
    }

    public TreeNode travel(TreeNode node, TreeNode ptr) {
        if (node == null) {
            return ptr;
        }
        ptr = travel(node.left, ptr);
        ptr.right = new TreeNode(node.val);
        return travel(node.right, ptr.right);
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
    }
}
