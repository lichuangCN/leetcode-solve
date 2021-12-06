package site.muzhi.leetcode.cla.interview.chapter7;

/**
 * @author lichuang
 * @date 2021/05/08
 * @description 寻找重复数
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xabtn6/
 */
public class $4_findDuplicate {

    public int findDuplicate(int[] nums) {
        while (true) {
            int n = nums[0];
            if (n == nums[n]) {
                return n;
            }
            // 交换位置
            nums[0] = nums[n];
            nums[n] = n;
        }
    }

    public int findDuplicate_1(int[] nums) {
        int fast = 0, slow = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (nums[fast] == nums[slow]) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[fast];
            }
        }
    }
}
