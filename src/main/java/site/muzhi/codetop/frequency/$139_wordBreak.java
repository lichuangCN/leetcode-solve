package site.muzhi.codetop.frequency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/08/10
 * 139.单词拆分
 */
public class $139_wordBreak {


    /*
     * 动态规划 dp[i] = dp[j] && wordDict.contains(s.substring(j,i))
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    /*
     * 递归回溯相当于暴力求解的一种，还是会超时
     */
//    boolean exist = false;
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        travel(s, new ArrayDeque<>(), wordDict);
//        return exist;
//    }
//
//    private void travel(String s, Deque<String> curr, List<String> wordDict) {
//        if (exist) {
//            return;
//        }
//        String currStr = String.join("", curr);
//        // 当前拼接字符串长度超过目标串 或者 当前片段已经不匹配
//        if (s.length() < currStr.length() || !currStr.equals(s.substring(0, currStr.length()))) {
//            return;
//        }
//        if (s.equals(currStr)) {
//            exist = true;
//            return;
//        }
//        for (int i = 0; i < wordDict.size(); i++) {
//            curr.addLast(wordDict.get(i));
//            travel(s, curr, wordDict);
//            curr.removeLast();
//        }
//    }
}
