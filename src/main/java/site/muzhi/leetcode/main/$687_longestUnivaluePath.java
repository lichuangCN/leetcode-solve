package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/25
 * 687.最长同值路径
 */
public class $687_longestUnivaluePath {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        travel(root);
        return max;
    }

    private int travel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = travel(root.left), right = travel(root.right);
        int tar = 0, curr = 0;
        if (root.left != null && root.left.val == root.val) {
            tar = left + 1;
            curr += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            // 路径, 根节点左右两侧的最大值，而不是连通路径最大值
            tar = Math.max(tar, right + 1);
            curr += right + 1;
        }

        max = Math.max(max, curr);
        return tar;
    }
}
