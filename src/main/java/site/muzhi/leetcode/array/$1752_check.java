package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2022/11/27
 * @description 1752. 检查数组是否经排序和轮转得到
 * <p>
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 * <p>
 * 数组分为两段：各自都是非递减序列
 */
public class $1752_check {

    public boolean check(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            int ptr = 1, len = nums.length;
            // 寻找第一段非递减序列
            while (ptr < len && nums[ptr - 1] <= nums[ptr]) {
                ptr++;
            }
            // 整段都是非递减序列
            if (ptr >= len) {
                return true;
            }

            // 寻找第二段非递减序列
            while (ptr < len - 1 && nums[ptr] <= nums[ptr + 1]) {
                ptr++;
            }

            // 遍历到最后 && nums[0] < nums[nums.length - 1]
            // nums[0] < nums[nums.length - 1] 是符合条件的必要条件
            return ptr == len - 1 && nums[0] >= nums[len - 1];
    }
}
