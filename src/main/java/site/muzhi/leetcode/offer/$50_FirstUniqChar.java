package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2022/03/07
 * @description 面试题50. 第一个只出现一次的字符
 * <p>
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class $50_FirstUniqChar {

    public char firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return ' ';
        }
        int[] dict = new int[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            dict[array[i] - 'a']++;
        }

        for (int i = 0; i < array.length; i++) {
            if (dict[array[i] - 'a'] == 1) {
                return array[i];
            }
        }

        return ' ';
    }
}
