package site.muzhi.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/01/18
 * 3. 无重复字符的最长子串
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Set<Character> dict = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            // 当前窗口 出现重复字符
            if (dict.contains(curr)) {
                ans = Math.max(ans, right - left);
                // 左指针右移 并且移除左侧元素
                while (dict.contains(curr)) {
                    dict.remove(s.charAt(left++));
                }
            }
            dict.add(curr);
            right++;
        }
        ans = Math.max(ans, right - left);
        return ans;
    }
}
