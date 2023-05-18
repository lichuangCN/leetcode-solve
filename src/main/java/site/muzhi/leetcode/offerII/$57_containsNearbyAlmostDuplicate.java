package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;
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
        // bucket中的元素仅是 区间长度 = k的元素集合
        Map<Long, Long> bucket = new HashMap<>();
        long w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucketId = bucketId(num, w);
            // 当前桶中存在元素: 即满足abs(nums[i] - nums[j]) <= t, 且滑动窗口内的元素，必满足 abs(i - j) <= k
            if (bucket.containsKey(bucketId)) {
                return true;
            }
            // 相邻桶
            if (bucket.containsKey(bucketId - 1) && Math.abs(num - bucket.get(bucketId - 1)) <= t) {
                return true;
            }
            if (bucket.containsKey(bucketId + 1) && Math.abs(num - bucket.get(bucketId + 1)) <= t) {
                return true;
            }
            // 添加窗口元素
            bucket.put(bucketId, num);

            // 移除已经不在窗口中的元素
            if (i > k) {
                bucket.remove(bucketId(nums[i - k], w));
            }
        }
        return false;
    }

    /**
     * 获取元素 num 所分配的桶 id
     */
    private long bucketId(long num, long w) {
        if (num >= 0) {
            return num / w;
        }
        // 不是很明白, 是因为存在 num < 0 ?
        return (num + 1) / (w - 1);
    }


    public boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t) {
        TreeSet<Long> win = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            // floor() ceiling()
            Long gt = win.floor(num);
            Long lt = win.ceiling(num);
            if (gt != null || gt - num <= t) {
                return true;
            }
            if (lt != null || num - gt <= t) {
                return true;
            }
            win.add(num);
            if (i > k) {
                win.remove(nums[k - i]);
            }
        }
        return false;
    }

}
