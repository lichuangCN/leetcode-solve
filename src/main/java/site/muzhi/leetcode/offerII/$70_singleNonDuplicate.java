package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/08
 * 70.排序数组中只出现一次的数据
 */
public class $70_singleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if ((mid & 1) == 0) {
                // 偶数
                if (nums[mid] == nums[mid + 1]) {
                    // [left, mid-1]满足规则
                    left = mid + 1;
                } else {
                    // mid 可能是目标值
                    right = mid;
                }
            } else {
                // 奇数
                if (nums[mid - 1] == nums[mid]) {
                    // [left, mid]满足规则
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
