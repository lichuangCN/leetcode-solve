package site.muzhi.leetcode.clazz.interview.chapter1;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 单词拆分II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa9v8i/
 */
public class $9_wordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        track(map, wordDict, s);
        return map.get(s);
    }

    /**
     * 回溯
     *
     * @param map
     * @param wordDict
     * @param s
     * @return
     */
    public List<String> track(Map<String, List<String>> map, List<String> wordDict, String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s == null || s.isEmpty()) {
            return Arrays.asList("");
        }
        List<String> list = new ArrayList<>();
        for (String w : wordDict) {
            if (s.length() < w.length() || !s.substring(0, w.length()).equals(w)) {
                continue;
            }
            List<String> track = track(map, wordDict, s.substring(w.length()));
            for (String t : track) {
                list.add(w + (t.isEmpty() ? "" : " " + t));
            }
        }
        map.put(s, list);
        return list;
    }
}
