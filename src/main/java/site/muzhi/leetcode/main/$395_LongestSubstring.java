package site.muzhi.leetcode.main;

import java.util.HashMap;

/**
 * @author lichuang
 * @date 2021/02/27
 * @description 至少有 K 个重复字符的最长子串
 */
public class $395_LongestSubstring {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character ch : map.keySet()) {
            if (map.get(ch) < k) {
                int res = 0;
                for (String sub : s.split(String.valueOf(ch))) {
                    res = Math.max(res, longestSubstring(sub, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
