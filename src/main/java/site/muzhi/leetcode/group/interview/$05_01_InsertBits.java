package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/02/28
 * @description
 */
public class $05_01_InsertBits {

    public int insertBits(int N, int M, int i, int j) {
        // 1.指定位置置0
        int mask = ((1 << (j - i + 1)) - 1) << i;
        mask = ~mask;
        N &= mask;
        // 2.处理M
        M = M << i;
        // 3.替换
        N = N | M;
        return N;
    }
}
