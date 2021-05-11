package site.muzhi.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349.给定两个数组，编写一个函数来计算它们的交集。 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
 *
 * @author lichuang
 * @date 2020/02/06
 */
public class $349_IntersectionOfTwoArrays1 {

    /**
     * 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length + nums2.length];
        int idx1 = 0, idx2 = 0, idx = 0;
        // 两个数组只要有一个到头，停止
        while (idx1 < nums1.length && idx2 < nums2.length) {
            int n1 = nums1[idx1], n2 = nums2[idx2];
            if (n1 == n2) {
                // 去重
                if (idx == 0 || res[idx - 1] != n1) {
                    res[idx++] = n1;
                }
                idx1++;
                idx2++;
            } else if (n1 < n2) {
                idx1++;
            } else {
                idx2++;
            }
        }
        int[] r = new int[idx];
        // 重新导出结果
        for (int i = 0; i < idx; i++) {
            r[i] = res[i];
        }
        return r;
    }

    /**
     * 通过set集合取交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[]  intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> tempSet = new HashSet<Integer>();
        HashSet<Integer> resultSet = new HashSet<Integer>();
        for (int i : nums1) {
            tempSet.add(i);
        }
        for (int j : nums2) {
            if (tempSet.contains(j)) {
                resultSet.add(j);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int ele : resultSet) {
            result[index] = ele;
            index++;
        }
        return result;
    }

}
