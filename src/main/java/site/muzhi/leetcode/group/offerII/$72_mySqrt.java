package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/06/09
 * 72.求平方根
 */
public class $72_mySqrt {

    public int mySqrt(int x) {
        int left = 1, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
