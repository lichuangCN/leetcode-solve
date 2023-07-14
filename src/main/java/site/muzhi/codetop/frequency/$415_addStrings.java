package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/14
 * 415.字符串相加
 */
public class $415_addStrings {

    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            int sum, rem;
            if (idx1 >= 0 && idx2 >= 0) {
                sum = num(num1.charAt(idx1)) + num(num2.charAt(idx2)) + add;
                idx1--;
                idx2--;
            } else if (idx1 >= 0) {
                sum = num(num1.charAt(idx1)) + add;
                idx1--;
            } else {
                sum = num(num2.charAt(idx2)) + add;
                idx2--;
            }
            add = sum / 10;
            rem = sum % 10;
            ans.append(rem);
        }
        if (add != 0) {
            ans.append(add);
        }
        return ans.reverse().toString();
    }

    private int num(char c) {
        return c - '0';
    }
}
