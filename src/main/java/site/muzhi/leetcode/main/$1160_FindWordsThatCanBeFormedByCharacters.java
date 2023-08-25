package site.muzhi.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: lichuang
 * @date: 2020/03/17
 * @description:
 */

public class $1160_FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        if (words.length == 0 || chars == null || "".equals(chars)) {
            return 0;
        }
        Map<Character, Integer> charsMap = hashWord(new HashMap<Character, Integer>(), chars);
        int result = 0;
        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap = hashWord(wordMap, words[i]);
            boolean isWord = true;
            Set<Character> set = wordMap.keySet();
            for (Character c : set) {
                if (!charsMap.containsKey(c) || wordMap.get(c) > charsMap.get(c)) {
                    isWord = false;
                    break;
                }
            }
            if (isWord) {
                result += words[i].length();
            }

        }
        return result;
    }

    /**
     * 将字符转为Map映射
     *
     * @param word
     * @return
     */
    private Map<Character, Integer> hashWord(Map<Character, Integer> wordMap, String word) {
        wordMap.clear();
        for (int i = 0; i < word.length(); i++) {
            if (wordMap.containsKey(word.charAt(i))) {
                wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
            } else {
                wordMap.put(word.charAt(i), 1);
            }
        }
        return wordMap;
    }
}
