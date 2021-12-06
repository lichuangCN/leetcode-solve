package site.muzhi.leetcode.cla.primaryalgorithm.chapter6;

import java.util.Random;

/**
 * @author lichuang
 * @date 2021/05/22
 * @description 打乱数组
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn6gq1/
 */
public class $1_Solution {

    class Solution {

        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (this.nums == null) {
                return null;
            }
            int[] arr = this.nums.clone();
            for (int i = 1; i < arr.length; i++) {
                int j = random.nextInt(i + 1);
                // 交换位置
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
            return arr;
        }
    }
}
