package site.muzhi.cla.interview.chapter1;

import java.util.HashSet;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 单词拆分
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa503c/
 */
public class $8_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // 有效值从[0,s.length()]
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 即s中[0,j)区间的字符串是否满足长度
                // 如果[0,j)区间的字符串满足要求，并且[j,i)区间的字符串也满足要求，则[0,i)区间的字符串也满足要求
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
