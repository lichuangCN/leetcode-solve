package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/16
 * 209.长度最小的子数组
 */
public class $209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, ans = nums.length, sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            if (sum >= target) {
                // 需要在这里处理 窗口内的元素
                while (sum - nums[left] >= target) {
                    sum -= nums[left++];
                }
                ans = Math.min(ans, right - left + 1);
            }
            right++;
        }
        if (sum < target) {
            return 0;
        }
        return ans;
    }
}
