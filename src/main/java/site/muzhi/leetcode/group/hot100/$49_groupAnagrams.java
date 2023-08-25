package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/08/25
 * 49.字母异位词分组
 */
public class $49_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String parse = parse(str);
            List<String> list = map.getOrDefault(parse, new ArrayList<>());
            list.add(str);
            map.put(parse, list);
        }

        return new ArrayList<>(map.values());
    }

    private String parse(String s) {
        int[] charsCount = new int[26];
        for (char c : s.toCharArray()) {
            charsCount[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charsCount.length; i++) {
            builder.append((char) (i + 'a')).append(charsCount[i]);
        }
        return builder.toString();
    }
}
