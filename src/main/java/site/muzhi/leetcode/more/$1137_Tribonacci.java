package site.muzhi.leetcode.more;

/**
 * @author lichuang
 * @date 2021/08/08
 * @description 1137. 第 N 个泰波那契数
 * <p>
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class $1137_Tribonacci {

    /**
     * 状态转移法
     *
     * @param n
     * @return
     */
    public int tribonacci_1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    /**
     * 递归优化法
     *
     * @param n
     * @return
     */

    int[] cache = new int[40];

    public int tribonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return cache[n];
    }


}
