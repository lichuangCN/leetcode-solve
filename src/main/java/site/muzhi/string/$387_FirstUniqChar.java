package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/12/23
 * @description 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，
 * 并返回它的索引。如果不存在，则返回 -1。
 */
public class $387_FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[charArray[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (count[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
