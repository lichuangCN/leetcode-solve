package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/13
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * 状态转义方程：
 *          {dp[i-1]+dp[i-2]} [i-1,i+1)即[i-1,i]可以组成新的字符
 * dp[i] =
 *          {dp[i-1]} [i-1,i+1)不可以组成新的字符
 */
public class $46_TranslateNum {


    public int translateNum(int num) {
        if (num < 0) {
            return 0;
        }
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len];
        // 初始化
        dp[0] = 1;
        // 判断dp[1]即第2个元素的值
        if (len >= 2) {
            Integer val = Integer.valueOf(s.substring(0, 2));
            if (10 <= val && val <= 25) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < len; i++) {
            Integer val = Integer.valueOf(s.substring(i - 1, i + 1));
            if (10 <= val && val <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
