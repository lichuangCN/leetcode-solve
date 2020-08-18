package site.muzhi.more;

/**
 * @author lichuang
 * @date 2020/05/11
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 思想：分治思想
 * 比如：2^32
 * 2^9 -> 2^4 -> 2^2 -> 2^1 -> 2^0
 * 注意: 要在合适的地方补充 乘以x
 */

public class $50_PowxN {


    public double myPow(double x, int n) {
        long N = n;
        return (n > 0) ? quickPow(x, N) : 1 / quickPow(x, -N);
    }

    /**
     * 递归解法
     *
     * @param x
     * @param n
     * @return
     */
    public double quickPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double ant = quickPow(x, n / 2);
        return (n % 2 == 0) ? ant * ant : x * ant * ant;
    }

    /**
     * 迭代解法
     *
     * @param x
     * @param N
     * @return
     */
    public double quickPow2(double x, long N) {
        // ant: 贡献值
        double res = 1.0, ant = x;
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果最低位是1，则纳入贡献值
                res *= ant;
            }
            // 将贡献值不断地平方
            ant *= ant;
            // 舍弃最低位
            N /= 2;
        }
        return res;
    }

}
