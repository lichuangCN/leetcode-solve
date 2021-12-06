package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/12/09
 * @description 把字符串转换成整数
 */
public class $67_StrToInt {

    public int strToInt(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        long res = 0;
        int idx = 0, len = str.length(), opt = 1;
        while (str.charAt(idx) == ' ') {
            if (++idx == len) {
                return 0;
            }
        }
        if (str.charAt(idx) == '-') {
            opt = -1;
        }
        if (str.charAt(idx) == '-' || str.charAt(idx) == '+') {
            idx++;
        }
        while (idx++ < len) {
            char at = str.charAt(idx);
            if (at < '0' || at > '9') {
                break;
            }
            int val = (at - '0') * opt;
            if (opt == 1 && (res * 10 + val > Integer.MAX_VALUE)) {
                return Integer.MAX_VALUE;
            }
            if (opt == -1 && (res * 10 + val) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + val;
            idx++;
        }
        return (int) res;
    }
}
