package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/04
 * 104.二叉树的最大深度
 */
public class $104_maxDepth {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
