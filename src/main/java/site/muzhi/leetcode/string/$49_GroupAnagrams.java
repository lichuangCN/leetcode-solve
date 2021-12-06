package site.muzhi.leetcode.string;

import java.util.*;

/**
 * @author lichuang
 * @date 2020/12/14
 * @description 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class $49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(0);
        }
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a'] += 1;
            }
            StringBuilder builder = new StringBuilder();
            // 将字符串按照字符顺序和次数进行拼接
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    builder.append((char) (i + 'a')).append(counts[i]);
                }
            }
            String key = builder.toString();
            List list = hashMap.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            hashMap.put(key, list);
        }
        ArrayList<List<String>> res = new ArrayList<>(hashMap.values().size());
        for (List list : hashMap.values()) {
            res.add(list);
        }
        return res;
    }
}
