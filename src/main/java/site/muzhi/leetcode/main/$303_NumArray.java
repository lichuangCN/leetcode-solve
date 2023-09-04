package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/01
 * @description
 * 思路有二：
 * 1.每次调用sumRange()方法的时候求和，效率低下
 * 2.先进行前n项的求和，即sum[j]-sum[i-1] = nums[i]+...+nums[j]
 */
public class $303_NumArray {

    class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            // 多一位,避免sumRange()中的if判断
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
