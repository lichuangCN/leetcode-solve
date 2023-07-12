package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 88.合并两个有序数组
 */
public class $88_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, idx_m = m - 1, idx_n = n - 1;
        while (idx >= 0) {
            if (idx_m >= 0 && idx_n >= 0) {
                if (nums1[idx_m] >= nums2[idx_n]) {
                    nums1[idx--] = nums1[idx_m--];
                } else {
                    nums1[idx--] = nums2[idx_n--];
                }
            } else if (idx_m >= 0) {
                nums1[idx--] = nums1[idx_m--];
            } else {
                nums1[idx--] = nums2[idx_n--];
            }
        }
    }
}
