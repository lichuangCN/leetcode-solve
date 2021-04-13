package site.muzhi.cla.interview.chapter1;

/**
 * @author lichuang
 * @date 2021/04/12
 * @description 只出现一次的数字
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xm0u83/
 */
public class $1_singleNumber {

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = (r ^ num);
        }
        return r;
    }
}
