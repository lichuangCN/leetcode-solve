package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/30
 */
public class $43_multiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();

        String ans = "0";
        for (int idx1 = arr1.length - 1; idx1 >= 0; idx1--) {
            StringBuilder t = new StringBuilder();
            int n1 = arr1[idx1] - '0';
            int add = 0;
            for (int idx2 = arr2.length - 1; idx2 >= 0; idx2--) {
                int n2 = arr2[idx2] - '0';
                t.append((n1 * n2 + add) % 10);
                add = (n1 * n2 + add) / 10;
            }
            if (add != 0) {
                t.append(add);
            }
            t.reverse();
            // 补0
            for (int i = idx1; i < arr1.length - 1; i++) {
                t.append("0");
            }
            ans = sum(ans, t.toString());
        }
        return ans;
    }

    private String sum(String num1, String num2) {
        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, add = 0;
        StringBuilder tar = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || add != 0) {
            int n1 = idx1 >= 0 ? arr1[idx1--] - '0' : 0;
            int n2 = idx2 >= 0 ? arr2[idx2--] - '0' : 0;
            tar.append((n1 + n2 + add) % 10);
            add = (n1 + n2 + add) / 10;
        }
        return tar.reverse().toString();
    }
}
