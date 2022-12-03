package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/03
 * @description 152. 乘积最大子数组
 */
public class $152_maxProduct {

    /**
     * 关键点就是这句话：“由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值min。”
     */
    public int maxProduct(int[] nums) {
        // max min 表示nums[i-1]时的最大 最小值
        int ans = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 当前值为负数，交换最大最小值
            int val = nums[i];
            if (val < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(val, max * val);
            min = Math.min(val, min * val);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
