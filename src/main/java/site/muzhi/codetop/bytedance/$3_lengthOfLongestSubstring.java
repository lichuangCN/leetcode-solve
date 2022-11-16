package site.muzhi.codetop.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2022/11/16
 * 3. 无重复字符的最长子串
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!set.contains(curr)) {
                set.add(curr);
                len = Math.max(len, i - left + 1);
            } else {
                // 将左指针右移
                while (set.contains(curr)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(curr);
            }
        }
        return len;
    }
}
