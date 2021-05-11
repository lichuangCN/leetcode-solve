package site.muzhi.cla.primaryalgorithm.chapter1;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 两个数组的交集 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 */
public class $6_intersect {

    /**
     * 有序数组，双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            int n1 = nums1[ptr1], n2 = nums2[ptr2];
            if (n1 == n2) {
                list.add(n1);
                ptr1++;
                ptr2++;
                continue;
            }
            if (n1 < n2) {
                ptr1++;
                continue;
            }
            if (n1 > n2) {
                ptr2++;
                continue;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 统计两个数组中每个元素出现的次数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect_1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            Integer val = map1.getOrDefault(num, 0);
            map1.put(num, val + 1);
        }
        for (int num : nums2) {
            Integer val = map2.getOrDefault(num, 0);
            map2.put(num, val + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer num = entry.getKey();
            if (map2.containsKey(num)) {
                int count = Math.min(entry.getValue(), map2.get(num));
                for (int i = 0; i < count; i++) {
                    list.add(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
