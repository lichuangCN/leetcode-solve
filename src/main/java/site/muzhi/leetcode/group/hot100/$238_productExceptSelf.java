package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/22
 * 238.除自身以外数组的乘积
 */
public class $238_productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] pre = new int[len];
        pre[0] = nums[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        int[] suf = new int[len];
        suf[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i];
        }

        int[] ans = new int[len];
        ans[0] = suf[1];
        ans[len - 1] = pre[len - 2];
        for (int i = 1; i <= len - 2; i++) {
            ans[i] = pre[i - 1] * suf[i + 1];
        }
        return ans;
    }
}
