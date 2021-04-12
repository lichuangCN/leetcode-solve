package site.muzhi.cla.interview;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2021/04/12
 * @description 多数元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xm77tm/
 */
public class $2_majorityElement {

    /**
     * 先排序，如果存在多数元素，位于中间的元素则一定是此元素
     *
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        int num = nums[nums.length / 2];
        return num;
    }

    /**
     * 累加
     *
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        int cur = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                cur = nums[i];
                count++;
            }
        }
        return cur;
    }
}
