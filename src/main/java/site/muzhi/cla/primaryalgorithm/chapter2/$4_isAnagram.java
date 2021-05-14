package site.muzhi.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 有效的字母异位词
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 */
public class $4_isAnagram {

    public boolean isAnagram(String s, String t) {
        if ((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
