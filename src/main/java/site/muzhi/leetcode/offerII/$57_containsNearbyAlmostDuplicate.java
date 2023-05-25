package site.muzhi.leetcode.offerII;

import java.util.TreeSet;

/**
 * @author lichuang
 * @date 2023/05/18
 * 57.值和下标之差都在给定范围内
 * <p>
 * 按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素。窗口大小 = k
 */
public class $57_containsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i] * 1L;
            // floor(e) : <= e
            Long lt = set.floor(num);
            // ceiling(e) : >= e
            Long gt = set.ceiling(num);
            if (lt != null && num - lt <= t) {
                return true;
            }
            if (gt != null && gt - num <= t) {
                return true;
            }
            set.add(num);
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }

}
