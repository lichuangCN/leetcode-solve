package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/03/06
 * 左右两边子数组的和相等
 */
public class $12_pivotIndex {

    public int pivotIndex(int[] nums) {

        int sum = 0, pre = 0;
        // sum 相当于前缀总和
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            // sum - pre - nums[i] i右侧元素总和
            if (pre == sum - pre - nums[i]) {
                return i;
            }
            // 当前前缀和
            pre += nums[i];
        }
        return -1;
    }


}
