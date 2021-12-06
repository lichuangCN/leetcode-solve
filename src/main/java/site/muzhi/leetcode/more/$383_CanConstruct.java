package site.muzhi.leetcode.more;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/12/04
 * @description 383. 赎金信
 * <p>
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class $383_CanConstruct {

    /**
     * 数组作为字典
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || "".equals(ransomNote)) {
            return true;
        }
        if (magazine == null || "".equals(magazine) || ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] dict = new int[26];
        // 统计可用的字母数
        for (char c : magazine.toCharArray()) {
            dict[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            dict[c - 'a']--;
            // 如果存在字母不够用，则表明不能够组成信件内容
            if (dict[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * 利用Map作为字典来映射
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct_1(String ransomNote, String magazine) {
        if (ransomNote == null || "".equals(ransomNote)) {
            return true;
        }
        if (magazine == null || "".equals(magazine) || ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            Integer count = map1.getOrDefault(c, 0);
            map1.put(c, count + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            Integer count = map2.getOrDefault(c, 0);
            map2.put(c, count + 1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer count = entry.getValue();
            if (!map2.containsKey(key) || map2.get(key) < count) {
                return false;
            }
        }

        return true;
    }
}
