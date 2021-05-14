package site.muzhi.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 整数反转
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 */
public class $2_reverse {

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            if (r < Integer.MIN_VALUE / 10 || r > Integer.MAX_VALUE / 10) {
                return 0;
            }
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}