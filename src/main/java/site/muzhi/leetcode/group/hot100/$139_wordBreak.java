package site.muzhi.leetcode.group.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/09/06
 * 139.单词拆分
 */
public class $139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
