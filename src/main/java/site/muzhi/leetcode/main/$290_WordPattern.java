package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2020/12/16
 * @description 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class $290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] wordArray = s.split(" ");
        if (pattern.length() != wordArray.length) {
            return false;
        }
        char[] charArray = pattern.toCharArray();
        Map<Character, String> charToStrMap = new HashMap<>();
        Map<String, Character> strToCharMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // 当前i位字母对应的单词已经发生了改变
            if (charToStrMap.containsKey(c) && !charToStrMap.get(c).equals(wordArray[i])) {
                return false;
            }
            // 当前i为单词对应的字母发生了改变
            if (strToCharMap.containsKey(wordArray[i]) && !strToCharMap.get(wordArray[i]).equals(c)) {
                return false;
            }
            strToCharMap.put(wordArray[i], c);
            charToStrMap.put(c, wordArray[i]);
        }
        return true;
    }
}
