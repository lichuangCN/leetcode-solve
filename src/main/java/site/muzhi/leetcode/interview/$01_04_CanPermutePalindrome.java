package site.muzhi.leetcode.interview;

import java.util.HashSet;

/**
 * @author lichuang
 * @date 2021/01/16
 * @description
 */
public class $01_04_CanPermutePalindrome {

    /**
     * Hash集合
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome_1(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                continue;
            }
            set.add(c);
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindrome_2(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int c = 0;
        for (int i = 0; i < 128; i++) {
            if ((count[i] & 1) == 1) {
                c++;
            }
            if (c > 1) {
                return false;
            }
        }
        return true;
    }
}
