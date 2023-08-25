package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/02/23
 */
public class $8_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum >= target) {
                // 尝试移除左侧元素，如果移除左侧元素后仍满足条件，则舍弃左侧元素
                while (sum - nums[left] >= target) {
                    sum -= nums[left];
                    left++;
                }
                // 重新计算最小区间长度
                ans = Math.min(ans, right - left + 1);
            }
            right++;
        }

        // 数组中不存在满足条件的子集
        if (sum < target) {
            return 0;
        }
        return ans;
    }
}
