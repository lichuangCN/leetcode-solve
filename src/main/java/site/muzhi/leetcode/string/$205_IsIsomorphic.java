package site.muzhi.leetcode.string;

import java.util.HashMap;

/**
 * @author lichuang
 * @date 2020/12/27
 * @description 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身
 */
public class $205_IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> s2tMap = new HashMap<>();
        HashMap<Character, Character> t2sMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ts = t.charAt(i);
            if (s2tMap.containsKey(cs) && !s2tMap.get(cs).equals(ts)) {
                return false;
            }
            if (t2sMap.containsKey(ts) && !t2sMap.get(ts).equals(cs)) {
                return false;
            }
            s2tMap.put(cs, ts);
            t2sMap.put(ts, cs);
        }
        return true;
    }
}
