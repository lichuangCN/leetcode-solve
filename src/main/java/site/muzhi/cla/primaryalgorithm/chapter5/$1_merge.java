package site.muzhi.cla.primaryalgorithm.chapter5;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description 合并两个有序数组
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 */
public class $1_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, ptr1 = m - 1, ptr2 = n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            while (ptr1 >= 0 && ptr2 >= 0 && nums1[ptr1] >= nums2[ptr2]) {
                nums1[idx--] = nums1[ptr1--];
            }
            while (ptr1 >= 0 && ptr2 >= 0 && nums1[ptr1] <= nums2[ptr2]) {
                nums1[idx--] = nums2[ptr2--];
            }

        }
        // 此时位置是正确的
        //while (ptr1 >= 0) {
        //    nums1[idx--] = nums1[ptr1--];
        //}
        while (ptr2 >= 0) {
            nums1[idx--] = nums2[ptr2--];
        }
    }
}
