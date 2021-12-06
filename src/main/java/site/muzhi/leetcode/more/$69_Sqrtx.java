package site.muzhi.leetcode.more;

/**
 * @author lichuang
 * @date 2020/05/09
 * @description 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */

public class $69_Sqrtx {

    /**
     * 牛顿迭代法
     * 迭代方程：x = (x + a/x) / 2;
     *
     * @param a
     * @return
     */
    public int mySqrt(int a) {
        if (a <= 0) {
            return 0;
        }
        double x = a;
        while (true) {
            // 迭代一次后的值
            double xi = (x + a / x) / 2;
            // 判断精度
            if (Math.abs(xi - x) < 1e-7) {
                break;
            }
            x = xi;
        }
        return (int) x;
    }

    /**
     * 二分法
     *
     * @param a
     * @return
     */
    public int mySqrt2(int a) {
        if (a <= 0) {
            return 0;
        }
        int left = 0, right = a / 2 + 1, res = -1;

        while (left <= right) {
            // 避免left+right的结果溢出
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= a) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
