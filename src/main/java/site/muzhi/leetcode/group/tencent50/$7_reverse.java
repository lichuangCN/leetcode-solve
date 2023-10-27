package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/20
 * 7.整数反转
 */
public class $7_reverse {

    public int reverse(int x) {
        // 2147483647
        // -2147483648
        int y = 0;
        // 如果要使得 y 溢出，则 x 的最小值是 1 463847412
        // 故当 y > 214748364 时，则会溢出
        while (x != 0) {
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}
