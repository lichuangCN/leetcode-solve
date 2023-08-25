package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/23
 * 23.最长有效括号
 */
public class $32_longestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    //
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
