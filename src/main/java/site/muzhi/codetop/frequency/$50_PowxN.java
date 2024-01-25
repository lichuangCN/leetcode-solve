package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/25
 * 50.Pow(x,n)
 */
public class $50_PowxN {

    public double myPow(double x, int n) {
        long N = n;
        return (N > 0) ? pow(x, n) : 1 / pow(x, -n);
    }

    /**
     * 分治 合并
     */
    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double anx = pow(x, n / 2);
        return n % 2 == 0 ? anx * anx : x * anx * anx;
    }
}
