package site.muzhi.more;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description:
 */

public class $231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // 如: 4 0100
        //    3 0011
        // 如果n为2的幂，则 n&(n-1)=0
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
