package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/27
 * 287.寻找重复数
 */
public class $287_findDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[fast];
            }
        }
    }
}
