package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/01/04
 * @description 斐波那契数列
 */
public class $509_Fib {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 迭代
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i0 = 0, i1 = 1;
        while (n > 1) {
            int t = i0 + i1;
            i0 = i1;
            i1 = t;
            n--;
        }
        return i1;
    }
}
