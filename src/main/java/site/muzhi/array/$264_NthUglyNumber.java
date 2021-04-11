package site.muzhi.array;

import java.util.HashSet;

/**
 * @author lichuang
 * @date 2021/04/11
 * @description 264. 丑数 II
 * <p>
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * <p>
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
 */
public class $264_NthUglyNumber {

    /**
     * 三路指针法
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int idx2 = 1, idx3 = 1, idx5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = dp[idx2] * 2, b = dp[idx3] * 3, c = dp[idx5] * 5;
            int min = Math.min(Math.min(a, b), c);
            if (min == a) {
                idx2++;
            }
            if (min == b) {
                idx3++;
            }
            if (min == c) {
                idx5++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
