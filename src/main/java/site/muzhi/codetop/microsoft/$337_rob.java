package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 337. 打家劫舍 III
 */
public class $337_rob {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] ans = travel(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] travel(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 后续遍历 需要先获取左右两个节点的情况，再判断当前节点是否下手偷窃
        int[] left = travel(node.left);
        int[] right = travel(node.right);

        // [0] node节点不偷 以node结点为根节点的子树能够偷窃的最大值
        // [1] node节点偷 以node结点为根节点的子树能够偷窃的最大值
        int[] dp = new int[2];

        // 当前节点值不偷，子节点可以偷也可以不偷，故只需要取左右子节点取最大值求和
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点偷，子节点则不能偷
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}
