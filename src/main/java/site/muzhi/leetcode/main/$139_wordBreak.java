package site.muzhi.leetcode.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lichuang
 * @date 2024/01/18
 * 139.单词拆分
 */
public class $139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
