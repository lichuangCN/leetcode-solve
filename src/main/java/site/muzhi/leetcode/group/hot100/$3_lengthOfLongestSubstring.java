package site.muzhi.leetcode.group.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/08/18
 * 3.无重复字符的最长子串
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length(), idx = 0, ans = 0;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!chars.contains(s.charAt(i))) {
                chars.add(s.charAt(i));
            } else {
                ans = Math.max(ans, i - idx);
                while (chars.contains(s.charAt(i))) {
                    chars.remove(s.charAt(idx++));
                }
                chars.add(s.charAt(i));
            }
        }
        // 比较最后一段字符长度
        return Math.max(ans, len - idx);
    }
}
