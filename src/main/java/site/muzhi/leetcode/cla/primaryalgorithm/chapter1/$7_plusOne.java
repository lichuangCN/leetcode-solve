package site.muzhi.leetcode.cla.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 加一
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 */
public class $7_plusOne {

    public int[] plusOne(int[] digits) {

        int opt = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int digit = digits[i];
            // 此时没有进位
            if (opt == 0) {
                return digits;
            }
            digits[i] = (digit + opt) % 10;
            opt = (digit + opt) / 10;
        }

        // 如果有进位
        if (opt != 0) {
            int[] res = new int[len + 1];
            res[0] = opt;
            for (int i = 1; i <= len; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

}
