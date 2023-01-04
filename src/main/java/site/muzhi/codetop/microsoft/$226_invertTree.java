package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/04
 * 反转二叉树
 */
public class $226_invertTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
