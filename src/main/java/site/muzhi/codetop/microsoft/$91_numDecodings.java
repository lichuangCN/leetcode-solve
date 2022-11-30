package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/30
 * @description 91. 解码方法
 */
public class $91_numDecodings {

    public int numDecodings(String s) {
        // s: 101
        if (s == null || "".equals(s)) {
            return 0;
        }
        // 占位
        s = " " + s;

        int[] dp = new int[s.length()];
        //
        dp[0] = 1;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            // a: s[i], b: s[i-1]s[i]
            int a = array[i] - '0';
            int b = (array[i - 1] - '0') * 10 + array[i] - '0';
            if (1 <= a && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= b && b <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
