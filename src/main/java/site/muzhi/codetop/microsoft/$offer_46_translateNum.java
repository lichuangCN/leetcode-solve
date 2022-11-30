package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/30
 * @description 剑指 Offer 46. 把数字翻译成字符串
 */
public class $offer_46_translateNum {
    public int translateNum(int num) {
        String code = String.valueOf(num);
        int len = code.length();

        int[] dp = new int[len + 1];
        // 初始化，第一个字符必定有一个值
        dp[0] = 1;

        code = " " + code;
        char[] array = code.toCharArray();
        for (int i = 1; i <= len; i++) {
            int x = (array[i - 1] - '0') * 10 + array[i] - '0';
            if (10 <= x && x <= 25) {
                //
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
