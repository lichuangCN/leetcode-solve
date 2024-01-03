package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/28
 * 32.最长有效括号
 */
public class $32_longestValidParentheses {

    public int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
