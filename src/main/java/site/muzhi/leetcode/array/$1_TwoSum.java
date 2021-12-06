package site.muzhi.leetcode.array;

import java.util.HashMap;

/**
 * Author: lichuang
 * Date: 2019/11/13
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。
 * 但是，你不能重复利用这个数组中同样的元素。
 */

public class $1_TwoSum {


    /**
     * 时间复杂度O(n*n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]) == target) {
                        num[0] = i;
                        num[1] = j;
                    }
                }
            }
        }
        return num;
    }

    /**
     * 时间复杂度O(n)
     * 本方法是将target-nums[i]为补数，作为k-v的键值，
     * 在遍历nums数组时，比较数组中是否存在值等于target-nums[i]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // target-nums[i]为k,数组下标i为v
            if (hashMap.containsKey(nums[i])) {
                indexs[0] = hashMap.get(nums[i]);
                indexs[1] = i;
            }

            hashMap.put(target - nums[i], i);
        }
        return indexs;
    }
}
