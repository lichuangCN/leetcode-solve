package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/30
 * 92.翻转字符
 */
public class $92_minFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] dp = new int[len][2];
        // [i][0] 第i位字符是'0'时翻转的最小次数
        // [i][1] 第i位字符是'1'时翻转的最小次数
        dp[0][0] = arr[0] == '0' ? 0 : 1;
        dp[0][1] = arr[1] == '1' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + (arr[i] == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (arr[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}
