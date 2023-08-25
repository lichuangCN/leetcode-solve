package site.muzhi.leetcode.group.interview;

import java.util.HashSet;

/**
 * @author lichuang
 * @date 2021/01/16
 * @description 确定字符互异
 */
public class $01_01_IsUnique {
    public boolean isUnique(String astr) {
        if (astr == null || "".equals(astr)) {
            return true;
        }
        HashSet<Character> set = new HashSet<>();
        char[] array = astr.toCharArray();
        for (char c : array) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
