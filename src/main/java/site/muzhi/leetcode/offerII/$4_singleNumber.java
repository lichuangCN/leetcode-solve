package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/02/14
 * 只出现一次的数字
 */
public class $4_singleNumber {

    public int singleNumber(int[] nums) {

        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            // bit位上 1出现的频率
            int count = 0;
            for (int num : nums) {
                // 有符号右移，依次取低位
                count += ((num >> i) & 1);
            }
            // 唯一出现的数字，在当前bit位上有值
            if (count % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
