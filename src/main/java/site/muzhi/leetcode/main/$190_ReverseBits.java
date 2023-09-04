package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/29
 * @description
 */
public class $190_ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
