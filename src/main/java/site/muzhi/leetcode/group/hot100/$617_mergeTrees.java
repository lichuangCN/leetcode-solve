package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/12
 * 617.合并二叉树
 */
public class $617_mergeTrees {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return travel(root1, root2);
    }

    private TreeNode travel(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = travel(root1.left, root2.left);
        node.right = travel(root1.right, root2.right);
        return node;
    }
}
