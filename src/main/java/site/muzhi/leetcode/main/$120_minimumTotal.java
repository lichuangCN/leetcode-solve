package site.muzhi.leetcode.main;

import java.util.List;

/**
 * @author lichuang
 * @date 2024/01/04
 * 120.三角形的最小路径和
 */
public class $120_minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        // 最大一行的元素个数 = 层数
        int[] dp = new int[triangle.size()];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < triangle.size(); i++) {
            int cur = Integer.MAX_VALUE;
            if (i == 0) {
                dp[0] = triangle.get(0).get(0);
                cur = dp[0];
            } else {
                List<Integer> level = triangle.get(i);
                // 必须要从后向前遍历，否则会使用覆盖后的新值
                for (int j = level.size() - 1; j >= 0; j--) {
                    if (j == 0) {
                        dp[j] = dp[j] + level.get(j);
                    } else if (j == level.size() - 1) {
                        dp[j] = dp[j - 1] + level.get(j);
                    } else {
                        dp[j] = Math.min(dp[j - 1], dp[j]) + level.get(j);
                    }
                    cur = Math.min(cur, dp[j]);
                }
            }
            ans = cur;
        }
        return ans;
    }
}
