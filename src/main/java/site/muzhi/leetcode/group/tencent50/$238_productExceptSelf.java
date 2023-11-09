package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/09
 * 238.除自身以外数组的乘积
 */
public class $238_productExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] prefix = new int[len];
        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        int[] suffix = new int[len];
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }

        int[] ans = new int[len];
        ans[0] = suffix[1];
        ans[len - 1] = prefix[len - 2];
        for (int i = 1; i <= len - 2; i++) {
            ans[i] = prefix[i - 1] * suffix[i + 1];
        }
        return ans;
    }
}
