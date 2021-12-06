package site.muzhi.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 3. 无重复字符的最长子串
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class $3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int left = 0, right = 0, len = 0;
        while (right < array.length) {
            while (right < array.length && !map.containsKey(array[right])) {
                map.put(array[right], right);
                right++;
            }
            len = Math.max(len, right - left);
            if (right == array.length) {
                return len;
            }

            int newLeft = map.get(array[right]) + 1;
            for (int i = left; i < newLeft; i++) {
                map.remove(array[i]);
            }
            left = newLeft;
        }
        return len;
    }
}
