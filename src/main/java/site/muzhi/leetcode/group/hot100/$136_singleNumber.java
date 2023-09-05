package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/05
 * 136.只出现一次的数字
 */
public class $136_singleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 异或
            ans ^= num;
        }
        return ans;
    }

}
