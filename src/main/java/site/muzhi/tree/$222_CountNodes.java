package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/08/31
 * @description
 */
public class $222_CountNodes {

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

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }

    /**
     * 分治法 将二叉树分为左右两个完全二叉树
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            // 左侧是一个满完全二叉树，右子树不一定是满完全二叉树
            // 计算右侧二叉树
            return (1 << left) + countNodes(root.right);
        } else {
            // 左侧不是一个满完全二叉树，右子树是一个满完全二叉树
            return (1 << right) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

}
