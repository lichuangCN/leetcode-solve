package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/01/11
 * 49 字母异位词分组
 */
public class $49_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(0);
        }

        Map<String, List<String>> dictMap = new HashMap<>();
        for (String s : strs) {
            // 统计
            String dict = count(s);
            List<String> list = dictMap.getOrDefault(dict, new ArrayList<>());
            list.add(s);
            dictMap.put(dict, list);
        }
        return new ArrayList<>(dictMap.values());
    }

    /**
     * 统计每个字母出现的次数，并进行拼接 如:a1b2c3
     */
    private String count(String s) {
        if ("".equals(s)) {
            return "";
        }
        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != 0) {
                builder.append((char) ('a' + i)).append(sCount[i]);
            }
        }
        return builder.toString();
    }
}
