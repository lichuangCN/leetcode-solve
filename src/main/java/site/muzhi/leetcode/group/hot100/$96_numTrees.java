package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/31
 * 96.不同的二叉搜索树
 */
public class $96_numTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

}
