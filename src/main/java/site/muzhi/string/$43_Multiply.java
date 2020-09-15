package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/09/15
 * @description 字符串相乘
 */
public class $43_Multiply {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {

        if (num1 == null || num1 == "" || num2 == null || num2 == "") {
            return "";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "0";
        for (int i = len1 - 1; i >= 0; i--) {
            StringBuilder r = new StringBuilder();
            int n1 = num1.charAt(i) - '0';
            // 低位相乘的进位
            int add = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int n = n1 * n2 + add;
                add = n / 10;
                r.append(n % 10);
            }
            // 最高位
            if (add != 0) {
                r.append(add);
            }
            // 补0
            r.reverse();
            for (int k = 0; k < len1 - i - 1; k++) {
                r.append("0");
            }
            res = sum(res, r.toString());
        }
        return res;
    }

    private static String sum(String num1, String num2) {
        if (num1 == null || num1 == "" || num2 == null || num2 == "") {
            return "";
        }
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int add = 0;
        StringBuilder r = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || add != 0) {
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int n = n1 + n2 + add;
            add = n / 10;
            r.append(n % 10);
            idx1--;
            idx2--;
        }
        return r.reverse().toString();
    }
}
