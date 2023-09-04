package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author: lichuang
 * @date: 2020/03/14
 * @description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 */

public class $300_LongestIncreasingSubsequence {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        // 因为最后一位不一定是最长值
        return result;
    }

    /**
     * 动态规划 + 二分查找
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 满足条件的子集长度
        int result = 0;
        // 遍历过程中，存放满足条件的子集
        int[] target = new int[nums.length];
        for (int num : nums) {
            // 采用二分法在结果子集中查找当前元素是否在子集target[0,result-1]中
            // 注：right指向的是末尾元素的后一位空值
            int left = 0, right = result;
            while (left < right) {
                int mid = (left + right) / 2;
                if (target[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 本行代码:1.将当前遍历到的num替换结果子集中的元素
            // 2.如果num大于子集中所有元素，此时left = right，即将新值加入结果最后一位
            target[left] = num;
            // 右侧指针没有移动，表示num为最大值，此时已经加入新元素，长度+1
            if (result == right) {
                result++;
            }
        }
        return result;
    }
}
