package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
 * 231.2的幂
 */
public class $231_isPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        // 2的幂值中，仅有1个bit位是1
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count == 1 ? true : false;
    }
}
