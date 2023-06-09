package site.muzhi.leetcode.offerII;

import java.util.Random;

/**
 * @author lichuang
 * @date 2023/06/09
 * 71.按权重生成随机数
 */
public class $71_RandomPickWithWeight {

    class Solution {

        int[] prefixSum;
        Random random = new Random();
        private int sum = 0;

        public Solution(int[] w) {
            prefixSum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                prefixSum[i] = sum + w[i];
                sum = prefixSum[i];
            }
            // 前缀和中 prefixSum[i]-prefixSum[i-1]表明下标i被选中的概率
            // 通过对前缀和数组进行二分查找，找到随机数落在的区间，即表明被选中的下标
            sum = prefixSum[w.length - 1];
        }

        public int pickIndex() {
            // 随机 [1,sum-1] 中的任意一个数字
            int r = random.nextInt(sum) + 1;
            int left = 0, right = prefixSum.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (prefixSum[mid] < r) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }
}
