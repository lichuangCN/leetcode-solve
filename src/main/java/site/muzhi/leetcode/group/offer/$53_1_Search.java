package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/02
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class $53_1_Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 向两边探索统计值
        left = mid;
        right = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return right == left ? 0 : right - left - 1;
    }
}
