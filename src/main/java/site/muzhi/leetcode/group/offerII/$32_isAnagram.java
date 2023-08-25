package site.muzhi.leetcode.group.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/04/11
 * 32.有效的变位词
 */
public class $32_isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char c : sArr) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : tArr) {
            if (!countMap.containsKey(c)) {
                return false;
            }
            Integer count = countMap.get(c) - 1;
            countMap.put(c, count);
            if (count == 0) {
                countMap.remove(c);
            }
        }

        return true;
    }
}
