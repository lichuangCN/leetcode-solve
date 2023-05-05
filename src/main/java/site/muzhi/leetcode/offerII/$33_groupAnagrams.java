package site.muzhi.leetcode.offerII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/04/14
 * 33.变位词组
 */
public class $33_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> countMap = new HashMap<>();
        for (String str : strs) {
            int[] charCount = new int[26];
            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] != 0) {
                    builder.append((char) (i + 'a')).append(charCount[i]);
                }
            }
            List<String> list = countMap.getOrDefault(builder.toString(), new ArrayList<>());
            list.add(str);
            countMap.put(builder.toString(), list);
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : countMap.values()) {
            ans.add(value);
        }
        return ans;
    }
}
