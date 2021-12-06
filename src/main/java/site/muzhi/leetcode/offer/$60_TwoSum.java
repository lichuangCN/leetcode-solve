package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/09/22
 * @description n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中
 * 第 i 小的那个的概率。
 */
public class $60_TwoSum {

    public double[] twoSum(int n) {
        // dp[i][s] 第i个骰子投出去后和为s出现的次数
        int[][] dp = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // s 投出第i个骰子后，可能出现的和
            for (int s = i; s <= i * 6; s++) {
                // j 第i个骰子可能投出的点数
                for (int j = 1; j <= 6; j++) {
                    // 如果之前(i-1)个投出的骰子的和(s-j)小于(i-1)
                    // 这种情况是不可能的
                    if ((s - j) < (i - 1)) {
                        break;
                    }
                    // 当前第i个骰子出现的点数之和等于前一次出现的点数之和加上这一次出现的点数
                    dp[i][s] += dp[i-1][s-j];
                }
            }
        }

        // 掷出n次点数出现的所有情况
        double total = Math.pow((double)6,(double)n);
        double[] res = new double[5*n+1];

        for (int i = n; i <= 6*n; i++) {
            res[i-n] = ((double) dp[n][i])/total;
        }
        return res;
    }

}
