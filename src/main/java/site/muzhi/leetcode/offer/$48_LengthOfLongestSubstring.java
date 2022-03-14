package site.muzhi.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/03/14
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class $48_LengthOfLongestSubstring {

    public static void main(String[] args) {
        int lengthOfLongestSubstring = lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
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
