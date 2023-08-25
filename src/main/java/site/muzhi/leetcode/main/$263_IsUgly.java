package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/10
 * @description 263. 丑数
 * <p>
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class $263_IsUgly {

    public boolean isUgly(int n) {
        if (n <= 1) {
            return n == 1 ? true : false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}