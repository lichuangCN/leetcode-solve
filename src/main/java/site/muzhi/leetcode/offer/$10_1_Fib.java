package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/28
 * @description 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class $10_1_Fib {
    /**
     * 1、递归方式
     * （超时）
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) % 1000000007 + fib(n - 2) % 1000000007;
    }

    /**
     * 2、自底向上迭代
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 1000000007;
        }
        return cache[n];
    }

    /**
     * 3、迭代
     */
    public int fib4(int n) {
        if (n <= 1) {
            return n;
        }
        int pre = 0, mid = 1, i = 2;
        while (i <= n) {
            int s = (pre + mid) % 1000000007;
            pre = mid;
            mid = s;
            i++;
        }
        return mid;
    }
}
