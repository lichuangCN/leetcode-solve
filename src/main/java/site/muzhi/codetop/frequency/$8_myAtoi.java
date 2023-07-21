package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/21
 * 8.字符串转换整数
 */
public class $8_myAtoi {

    public static void main(String[] args) {
        $8_myAtoi demo = new $8_myAtoi();
        demo.myAtoi("  ");
    }

    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int idx = 0;
        // 移除前导空格
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == s.length()) {
            return 0;
        }

        // 正负值
        int opt = 0;
        if (s.charAt(idx) == '-') {
            opt = -1;
            idx++;
        } else if (s.charAt(idx) == '+') {
            opt = 1;
            idx++;
        } else if (Character.isDigit(s.charAt(idx))) {
            opt = 1;
        } else {
            // 字母或其他开头
            return 0;
        }

        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, ans = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            int curr = s.charAt(idx) - '0';
            // ans * 10 + curr > max
            if (ans > (max - curr) / 10) {
                return opt > 0 ? max : min;
            }
            ans = ans * 10 + curr;
            idx++;
        }

        return opt * ans;
    }
}
