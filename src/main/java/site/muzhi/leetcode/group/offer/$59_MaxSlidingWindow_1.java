package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/10/22
 * @description 滑动窗口的最大值
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 <= k <= 输入数组的大小。
 */
public class $59_MaxSlidingWindow_1 {

    /**
     * 时间复杂度 O(n*k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        // 前k个元素最大值
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        res[0] = max;
        // 后nums.length - k个元素
        for (int i = k; i < nums.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i - k + 1; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i - k + 1] = max;
        }
        return res;
    }

}
