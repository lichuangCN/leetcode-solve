package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/17
 * 617 合并两个二叉树
 */
public class $617_mergeTress {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mergeTress(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTress(root1.left, root2.left);
        node.right = mergeTress(root1.right, root2.right);
        return node;
    }

}
