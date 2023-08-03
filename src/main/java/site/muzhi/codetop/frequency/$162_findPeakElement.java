package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/03
 * 162.寻找峰值
 */
public class $162_findPeakElement {

    public int findPeakElement(int[] nums) {

        // 记录数组中最大值的索引 默认数组左边界
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 二分查找：
     * 1.查找到中间的峰值
     * 2.查找到处于单调片段的左右边界
     */
    public int findPeakElement_2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
