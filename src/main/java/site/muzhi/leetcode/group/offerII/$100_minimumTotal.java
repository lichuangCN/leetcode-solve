package site.muzhi.leetcode.group.offerII;

import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/05
 * 100.三角形中最小路径之和
 */
public class $100_minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        // 初始化边界值
        dp[0] = triangle.get(0).get(0);
        int ans = dp[0];

        for (int i = 1; i < size; i++) {
            List<Integer> curr = triangle.get(i);
            // 记录到达第i层 的最小值
            int min = Integer.MAX_VALUE;
            // 需要从后向前遍历
            for (int j = curr.size() - 1; j >= 0; j--) {
                if (j == curr.size() - 1) {
                    // 当前层最后一个元素
                    dp[j] = dp[j - 1] + curr.get(j);
                } else if (j == 0) {
                    // 当前层第一个元素
                    dp[j] = dp[j] + curr.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + curr.get(j);
                }
                // 更新每层最小值
                min = Math.min(min, dp[j]);
            }
            ans = min;
        }
        return ans;
    }
}
