package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lichuang
 * @date 2020/10/28
 * @description 独一无二出现次数
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class $1207_UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> resSet = new HashSet<>();
        for (Integer key : countMap.keySet()) {
            resSet.add(countMap.get(key));
        }
        return resSet.size() == countMap.size();
    }
}
