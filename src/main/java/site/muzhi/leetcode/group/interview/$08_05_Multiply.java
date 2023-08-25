package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_05_Multiply {


    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A > B) {
            return A + multiply(A, B - 1);
        }
        return B + multiply(A - 1, B);
    }

    /**
     * 二进制位运算
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply_1(int A, int B) {
        int min = (A < B) ? A : B;
        int max = A + B - min;

        int res = 0;
        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                res += max << i;
            }
            min >>= 1;
        }
        return res;
    }
}
