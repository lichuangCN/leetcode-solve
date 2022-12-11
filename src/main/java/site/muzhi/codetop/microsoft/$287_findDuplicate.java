package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/11
 * @description 287. 寻找重复数
 */
public class $287_findDuplicate {

    public int findDuplicate(int[] nums) {
        //while (true) {
        //    // 因为一轮循环中会出现元素位置的交换，并且交换后的元素存在nums[0]这个闲置位
        //    int sentry = nums[0];
        //    if (nums[sentry] == sentry) {
        //        return sentry;
        //    }
        //    // 将元素放到指定位置
        //    nums[0] = nums[sentry];
        //    nums[sentry] = sentry;
        //}

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
