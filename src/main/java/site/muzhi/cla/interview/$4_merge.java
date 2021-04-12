package site.muzhi.cla.interview;

/**
 * @author lichuang
 * @date 2021/04/12
 * @description 合并两个有序数组
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xmi2l7/
 */
public class $4_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        while (m > 0 && n > 0) {
            while (m > 0 && n > 0 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[idx--] = nums1[m - 1];
                m--;
            }
            while (m > 0 && n > 0 && nums1[m - 1] < nums2[n - 1]) {
                nums1[idx--] = nums2[n - 1];
                n--;
            }
        }
        while (m > 0) {
            nums1[idx--] = nums1[m - 1];
            m--;
        }
        while (n > 0) {
            nums1[idx--] = nums2[n - 1];
            n--;
        }
    }
}
