package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/08
 * 337.打家劫舍 III
 */
public class $337_rob {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int rob(TreeNode root) {
        int[] dp = travel(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] travel(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = travel(root.left);
        int[] right = travel(root.right);

        // [0] 不偷
        // [1] 偷
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
