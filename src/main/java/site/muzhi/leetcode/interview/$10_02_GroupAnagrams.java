package site.muzhi.leetcode.interview;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/04/07
 * @description 面试题 10.02. 变位词组
 *
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 */
public class $10_02_GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            List<String> list = map.getOrDefault(ns, new ArrayList<>());
            list.add(s);
            map.put(ns,list);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
