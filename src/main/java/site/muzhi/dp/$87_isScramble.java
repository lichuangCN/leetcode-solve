package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/16
 * @description 87. 扰乱字符串
 * <p>
 * https://leetcode-cn.com/problems/scramble-string/
 */
public class $87_isScramble {

    public boolean isScramble(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        if (arr1.length != arr2.length) {
            return false;
        }
        int n = arr1.length;
        boolean[][][] dp = new boolean[n][n][n + 1];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = (arr1[i] == arr2[j]);
            }
        }

        // 枚举区间长度[2,n]
        for (int len = 2; len <= n; len++) {
            // 字符串s1
            for (int i = 0; i <= n - len; i++) {
                // 字符串s2
                for (int j = 0; j <= n - len; j++) {
                    // 划分位置
                    for (int k = 1; k <= len - 1; k++) {
                        // 比较两个位置
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }

            }
        }

        return dp[0][0][n];
    }
}
