package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/07/03
 * 93.最长斐波那契数列
 */
public class $93_lenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            idxMap.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 满足 arr[j]*2 > arr[i], 才可能存在k: k<j 满足 arr[k] + arr[j] = arr[i]
            for (int j = i - 1; j > 0 && arr[j] * 2 > arr[i]; j--) {
                Integer k = idxMap.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    // 以 arr[j] arr[i] 为最后两个元素的最长值
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }
}
