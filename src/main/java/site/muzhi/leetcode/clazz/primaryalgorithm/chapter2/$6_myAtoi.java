package site.muzhi.leetcode.clazz.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 字符串转换整数 (atoi)
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 */
public class $6_myAtoi {

    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        // 1.处理空格
        int idx = 0;
        while (idx < len && arr[idx] == ' ') {
            idx++;
        }
        if (idx == len) {
            return 0;
        }
        // 2.处理符号 false:-,true:+
        boolean ope = true;
        if (arr[idx] == '-') {
            ope = false;
            idx++;
        } else if (arr[idx] == '+') {
            ope = true;
            idx++;
        } else if (!Character.isDigit(arr[idx])) {
            // 非法字符
            return 0;
        }

        // 3.计算值
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, res = 0;
        while (idx < len && Character.isDigit(arr[idx])) {
            int val = arr[idx] - '0';
            if (res > (max - val) / 10) {
                return (ope) ? max : min;
            }
            res = res * 10 + val;
            idx++;
        }

        return ope ? res : -res;
    }

}
