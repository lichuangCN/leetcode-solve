package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/09/08
 * @description 最短无序连续子数组
 * <p>
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度
 */
public class $581_FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // min 需要进行排序片段的最小值
        // max 需要进行排序片段的最大值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > nums[j + 1]) {
                max = Math.max(max, nums[j]);
            }
        }
        int left, right;
        // 寻找左边界
        for (left = 0; left < nums.length; left++) {
            // 如果当前值比需要进行排序的最小值大，则是需要进行排序片段的左侧
            if (min < nums[left]) {
                break;
            }
        }
        // 右边界
        for (right = nums.length - 1; right >= 0; right--) {
            // 如果当前值比需要进行排序的最大值小，则是需要进行排序片段的右侧
            if (max > nums[right]) {
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }

    public int find2(int[] nums) {
        int right = 0, left = nums.length - 1;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    left = Math.min(left, i);
                    right = Math.max(right, j);
                }
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}
