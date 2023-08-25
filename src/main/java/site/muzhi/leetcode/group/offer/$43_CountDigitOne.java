package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 1～n整数中1出现的次数
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class $43_CountDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        // 位数
        int digit = 1;
        // 高位/当前指向位/低位
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                // 此时1出现的次数只能由当前高位决定
                res += high * digit;
            } else if (cur == 1) {
                // 此时1出现的次数由当前高位和当前低位共同决定
                // 并且加上此位出现的1
                res += high * digit + low + 1;
            } else {
                // 此时出现的次数只能由当前高位决定
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }

        return res;
    }
}
