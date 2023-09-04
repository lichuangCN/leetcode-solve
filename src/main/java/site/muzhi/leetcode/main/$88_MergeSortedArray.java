package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/10
 * @description: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

public class $88_MergeSortedArray {

    /**
     * 由后向前遍历，每次可以确定一个当前剩余元素中最大值的位置
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并过程中，每次确定一个元素的位置
        int index = m + n - 1;
        // 当两个数组中均还有元素时
        while (m != 0 && n != 0) {
            // 当nums2的最后一位大于nums1的最后一位
            while (m > 0 && n > 0 && nums1[m - 1] <= nums2[n - 1]) {
                nums1[index--] = nums2[n - 1];
                n--;
            }
            // 当nums2的最后一位小于nums1的最后一位
            while (m > 0 && n > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[m - 1];
                m--;
            }
        }
        // nums1还有剩余元素，将剩余元素填充
        while (n == 0 && m > 0) {
            nums1[index--] = nums1[m - 1];
            m--;
        }
        // nums2还有剩余元素，将剩余元素填充
        while (m == 0 && n > 0) {
            nums1[index--] = nums2[n - 1];
            n--;
        }
    }

}
