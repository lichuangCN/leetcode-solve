package site.muzhi.leetcode.string;

/**
 * @author lichuang
 * @date 2020/09/15
 * @description 字符串相加
 */
public class $415_AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1 == "" || num2 == null || num2 == "") {
            return "";
        }
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || add != 0) {
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int n = n1 + n2 + add;
            res.append(n % 10);
            add = n / 10;
            idx1--;
            idx2--;
        }
        return res.reverse().toString();
    }
}
