package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/07
 * 88.合并两个有序数组
 */
public class $88_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mp = m - 1, np = n - 1, tp = nums1.length - 1;
        while (mp >= 0 || np >= 0) {
            if (mp < 0) {
                nums1[tp--] = nums2[np--];
            } else if (np < 0) {
                nums1[tp--] = nums1[mp--];
            } else {
                if (nums1[mp] >= nums2[np]) {
                    nums1[tp--] = nums1[mp];
                    mp--;
                } else {
                    nums1[tp--] = nums2[np];
                    np--;
                }
            }
        }
    }
}
