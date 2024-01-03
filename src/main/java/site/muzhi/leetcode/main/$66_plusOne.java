package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 66.加一
 */
public class $66_plusOne {

    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            add = sum / 10;
            digits[i] = sum % 10;
        }

        // 进位
        if (add != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = add;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        return digits;
    }
}
