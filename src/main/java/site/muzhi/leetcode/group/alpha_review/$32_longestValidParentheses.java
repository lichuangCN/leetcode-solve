package site.muzhi.leetcode.group.alpha_review;

/**
 * @author lichuang
 * @date 2023/12/05
 */
public class $32_longestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length(), ans = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
