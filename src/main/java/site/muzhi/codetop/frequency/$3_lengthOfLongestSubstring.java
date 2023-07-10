package site.muzhi.codetop.frequency;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/07/10
 * 3.无重复字符的最长子串
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length(), left = 0, ans = 0;

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (!charSet.contains(curr)) {
                ans = Math.max(ans, i - left + 1);
            } else {
                // 移除左侧元素
                while (charSet.contains(curr)) {
                    charSet.remove(s.charAt(left++));
                }
            }
            charSet.add(curr);
        }
        return ans;
    }
}
