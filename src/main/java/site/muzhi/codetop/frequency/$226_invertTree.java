package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/03
 * 226.翻转二叉树
 */
public class $226_invertTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(left);
        invertTree(right);
        return root;
    }

}
