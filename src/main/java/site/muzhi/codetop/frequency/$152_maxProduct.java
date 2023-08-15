package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/15
 * 152.乘积最大子数组
 */
public class $152_maxProduct {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        // 因为存在负数，设置一个最大值数组，一个最小值数组
        int[] max = new int[len], min = new int[len];

        max[0] = min[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            //
            // max[i] = Math.max(nums[i], max[i - 1] * nums[i], min[i - 1] * nums[i])
            // min[i] = Main.min(nums[i], max[i - 1] * nums[i], min[i - 1] * nums[i])
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
            ans = Math.max(ans, max[i]);
        }
        return ans;

        // 空间优化版本
//        int max = nums[0], min = nums[0], ans = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            if (val < 0) {
//                int t = min;
//                min = max;
//                max = t;
//            }
//            max = Math.max(val, max * val);
//            min = Math.max(val, min * val);
//            ans = Math.max(max, ans);
//        }
//        return ans;
    }
}
