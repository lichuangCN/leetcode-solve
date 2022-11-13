package site.muzhi.codetop.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2022/11/13
 * @description 3. 无重复字符的最长子串
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        // abcd bcdef bb
        Set<Character> set = new HashSet<>();
        int len = 0, left = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                len = Math.max(len, i - left + 1);
            } else {
                // 移除出现重复元素前面的元素(包括重复元素)
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(left++));
                }
                set.add(s.charAt(i));
            }

        }
        return len;
    }
}
