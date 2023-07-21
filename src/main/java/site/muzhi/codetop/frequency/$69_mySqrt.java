package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/21
 * 69.x的平方根
 */
public class $69_mySqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x / 2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long curr = (long) mid * mid;
            if (curr == (long) x) {
                return mid;
            }
            if (curr < (long) x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
