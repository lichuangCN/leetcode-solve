package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/24
 * 43.字符串相乘
 */
public class $43_multiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        String ans = "0";
        for (int i = arr1.length - 1; i >= 0; i--) {
            int n1 = arr1[i] - '0', add = 0;
            StringBuilder t = new StringBuilder();
            for (int j = arr2.length - 1; j >= 0; j--) {
                int n2 = arr2[j] - '0';
                int sum = n1 * n2 + add;
                t.append(sum % 10);
                add = sum / 10;
            }
            if (add != 0) {
                t.append(add);
            }
            // 翻转
            t.reverse();
            // 补0
            for (int k = 0; k < arr1.length - 1 - i; k++) {
                t.append("0");
            }

            // 累加
            ans = sum(ans, t.toString());
        }
        return ans;
    }

    private String sum(String num1, String num2) {
        StringBuilder t = new StringBuilder();
        int add = 0, idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        while (idx1 >= 0 || idx2 >= 0) {
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int sum = n1 + n2 + add;
            add = sum / 10;
            t.append(sum % 10);
            idx1--;
            idx2--;
        }
        if (add != 0) {
            t.append(add);
        }
        return t.reverse().toString();
    }
}
