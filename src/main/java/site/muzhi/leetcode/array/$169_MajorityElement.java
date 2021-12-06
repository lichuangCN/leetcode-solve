package site.muzhi.leetcode.array;

import java.util.Arrays;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description: 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class $169_MajorityElement {

    /**
     * 采用摩根计数法，遇到相同的值+1,不同的值-1，如果计数为0，则重新选取一个数作为值
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else {
                count = (result == nums[i]) ? count + 1 : count - 1;
            }
        }
        return result;
    }

    /**
     * 先排序，根据题意 nums[n/2]必定是目标元素
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
