package site.muzhi.leetcode.clazz.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 只出现一次的数字
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 */
public class $5_singleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }
}
