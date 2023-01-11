package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/11
 * 238 除自身以外数组的乘积
 */
public class $238_productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] pre1 = new int[len], pre2 = new int[len];
        // 从前向后遍历 前缀和
        pre1[0] = nums[0];
        for (int i = 1; i < len; i++) {
            pre1[i] = pre1[i - 1] * nums[i];
        }
        // 从后向前遍历 前缀和
        pre2[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            pre2[i] = pre2[i + 1] * nums[i];
        }

        int[] ans = new int[len];
        // 首位 和 末尾
        ans[0] = pre2[1];
        ans[len - 1] = pre1[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = pre1[i - 1] * pre2[i + 1];
        }
        return ans;
    }
}
