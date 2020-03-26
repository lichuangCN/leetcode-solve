package site.muzhi.interview;

/**
 * @author: lichuang
 * @date: 2020/03/24
 * @description: 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），
 * 返回总的分钟数。
 */

public class $17_16_Massage {
    /**
     * 采用dp的解法1:
     * 递推表达式：dp[i] = nums[i]+Max(dp[0]...dp[i-1])
     * 假设第i次预约，计算此次预约成功后的最大值存入dp[i]
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        // 记录[0,i-2]之中的最大值
        int maxValue = dp[0];
        // 记录遍历过程中出现的最大值，即返回结果
        int result = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            // 每次都要计算[0,i-2]之中的最大值
            maxValue = Math.max(maxValue, dp[i - 2]);
            // 计算到第i个位置时的最大值
            dp[i] = nums[i] + maxValue;
            // 重新计算最大值
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 采用dp解法2：
     * 递推表达式：dp[i] = Max(nums[i]+dp[i-2],dp[i-1])
     * dp[i]存放的[0,i]中的最大值
     *
     * @param nums
     * @return
     */
    public int massage2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
