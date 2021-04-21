package site.muzhi.string;

/**
 * @author lichuang
 * @date 2021/04/21
 * @description 91. 解码方法
 * <p>
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class $91_NumDecodings {

    public int numDecodings_1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        // 占位
        s = " " + s;
        char[] arr = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            // item1表示单独解码
            int item1 = arr[i] - '0';
            // item2表示和前一位组合解码
            int item2 = (arr[i - 1] - '0') * 10 + (arr[i] - '0');
            if (1 <= item1 && item1 <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= item2 && item2 <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[len];
    }
}
