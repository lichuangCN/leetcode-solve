package site.muzhi.day;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 出现已经做过的题目时，在此类中完成此题的代码的编写
 */
public class TodayQuestion {

    public double myPow(double x, int n) {
        double val = quickPow(x, n);
        return n > 0 ? val : 1 / val;
    }

    public double quickPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ant = quickPow(x, n / 2);
        return (n & 1) == 0 ? ant * ant : ant * ant * x;
    }

    public static void main(String[] args) {
        quickPow_2(2.0, -2);
    }

    public static double quickPow_2(double x, int n) {

        int idx = n;
        double res = 1.0, ans = x;
        while (idx != 0) {
            if ((idx & 1) == 1) {
                res *= ans;
            }
            ans *= ans;
            idx /= 2;
        }
        return n > 0 ? res : 1 / res;
    }
}
