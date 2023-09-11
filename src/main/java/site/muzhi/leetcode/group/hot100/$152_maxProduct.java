package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/11
 * 152.乘积最大子数组
 */
public class $152_maxProduct {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len], min = new int[len];
        max[0] = min[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(Math.max(nums[i], max[i - 1] * nums[i]), min[i - 1] * nums[i]);
            min[i] = Math.min(Math.min(nums[i], max[i - 1] * nums[i]), min[i - 1] * nums[i]);
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
