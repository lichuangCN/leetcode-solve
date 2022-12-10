package site.muzhi.codetop.microsoft;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 139. 单词拆分
 */
public class $139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());
        int len = s.length();
        // dp[i] 表示[1,i]个字符 是否可以从单词集合中拼出
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 表示[0,j)字符区间是否满足
                // 如果[0,j)区间满足 并且 [j,i)可以满足，则意味着 [0,i]区间也是满足的
                // [0,len) 表明全字符串
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }

}
