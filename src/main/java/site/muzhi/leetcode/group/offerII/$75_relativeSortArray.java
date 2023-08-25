package site.muzhi.leetcode.group.offerII;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author lichuang
 * @date 2023/06/14
 * 75.数组相对排序
 */
public class $75_relativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 有序map
        Map<Integer, Integer> arrMap = new TreeMap<>((x, y) -> x - y);
        for (int n : arr1) {
            arrMap.put(n, arrMap.getOrDefault(n, 0) + 1);
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int n : arr2) {
            for (int i = idx; i < arrMap.get(n) + idx; i++) {
                ans[i] = n;
            }
            idx += arrMap.get(n);
            arrMap.remove(n);
        }
        // 多余的数字
        for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
            Integer n = entry.getKey();
            Integer count = entry.getValue();
            for (int i = idx; i < count + idx; i++) {
                ans[i] = n;
            }
            idx += count;
        }
        return ans;
    }
}
