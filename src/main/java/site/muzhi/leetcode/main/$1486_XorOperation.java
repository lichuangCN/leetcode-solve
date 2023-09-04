package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/05/07
 * @description 1486. 数组异或操作
 * <p>
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class $1486_XorOperation {

    /**
     * 连续四个自然数，一循环归零
     * <p>
     * 如 0^1^2^3 = 0
     * <p>
     * 世界是个圈
     *
     * @param n
     * @return
     */
    private int calc(int n) {
        if (n % 4 == 0) {
            return n;
        }
        if (n % 4 == 1) {
            return 1;
        }
        if (n % 4 == 2) {
            return n + 1;
        }
        return 0;
    }

    public int xorOperation(int n, int start) {
        int s = start >> 1;
        int prefix = calc(s - 1) ^ calc(s + n - 1);

        int last = n & start & 1;
        int res = prefix << 1 | last;
        return res;
    }
}
