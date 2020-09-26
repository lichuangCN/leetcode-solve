package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/09/26
 * @description 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class $27_MirrorTree {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
