package site.muzhi.cla.interview.chapter7;

/**
 * @author lichuang
 * @date 2021/05/08
 * @description 寻找峰值
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xacqw5/
 */
public class $3_findPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 迭代
     *
     * @param nums
     * @return
     */
    public int findPeakElement_1(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
