package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/22
 * 136.只出现一次的数字
 */
public class $136_singleNumber {

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
