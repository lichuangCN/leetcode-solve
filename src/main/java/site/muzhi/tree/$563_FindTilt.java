package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/11/11
 * @description 二叉树的坡度
 */
public class $563_FindTilt {
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

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return tilt;
        }
        travel(root);
        return tilt;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = travel(node.left);
        int right = travel(node.right);
        // node子节点的梯度之和
        tilt += Math.abs(left - right);
        // left + right + node.val  node这棵树的所有节点之和
        return left + right + node.val;
    }
}
