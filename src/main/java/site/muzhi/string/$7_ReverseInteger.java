package site.muzhi.string;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 解题思路利用求余数的方式。
 * 最大的值与最小的值为：[−2^31, 2^31 − 1]
 * 即：[-2147483648, 2147483647]
 */

public class $7_ReverseInteger {
    public int reverse(int x) {
        int y = 0;
        // 如果y = y * 10 + x % 10溢出，则 y>=214748364 ，
        // 当y=214748364时，输入的值只能为：1463847412，此时不溢出
        // 即：y > 214748364 || y < -214748364 必定溢出
        while (x != 0) {
            if (y < Integer.MIN_VALUE / 10 || y > Integer.MAX_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}
