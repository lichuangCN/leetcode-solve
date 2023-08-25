package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/23
 * @description 不用加减乘除做加法
 */
public class $65_Add {
    public int add(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // a^b 无进位和
        // a&b 进位值，a&b<<1 真正的进位值,要向左进一位
        return add(a ^ b, (a & b) << 1);
    }
}
