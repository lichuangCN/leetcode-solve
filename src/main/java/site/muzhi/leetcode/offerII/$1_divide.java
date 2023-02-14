package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/02/02
 * 1.整数除法
 */
public class $1_divide {

    public int divide(int a, int b) {
        // 考虑边界场景
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : -1;
        // 统一转为负值处理
        int x = (a > 0) ? -a : a;
        int y = (b > 0) ? -b : b;
        int result = 0;
        while (x <= y) {
            x -= y;
            result++;
        }
        return sign == 1 ? result : -result;
    }
}
