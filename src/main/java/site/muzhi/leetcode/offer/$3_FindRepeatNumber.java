package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/13
 * @description 剑指 Offer 03. 数组中重复的数字
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字
 * <p>
 * 批注：此题涉及多个潜在的条件
 * 1、空间复杂度优先
 * 2、时间复杂度优先(用哈希表)
 * 3、空间复杂度O(1),并且不修改原数组
 */
public class $3_FindRepeatNumber {
    /**
     * 时间复杂度优先
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int findRepeatNumber1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 新开辟空间建立数组，记录原数组nums中的值出现的次数
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 空间复杂度优先
     * nums[i]<-->i 一一对应
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 设nums[i] = k, nums[i] == nums[nums[i]] 转化为==> k == nums[k]
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 将 nums[i] = k 放到 nums[k]上
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }
}
