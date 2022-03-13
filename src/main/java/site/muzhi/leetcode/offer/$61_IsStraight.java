package site.muzhi.leetcode.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2022/03/13
 * @description 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * <p>
 * 题解：需要同时满足下面两个条件
 * 条件1：除大小王外，无重复牌
 * 条件2：除大小王外，max-min<5;
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
 */
public class $61_IsStraight {

    /**
     * 集合Set
     */
    public boolean isStraight_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            // 大小王不处理
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 存在重复，直接返回
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }

    /**
     * 排序
     */
    public boolean isStraight_2(int[] nums) {
        Arrays.sort(nums);
        // 定位大小王的个数
        int idx = 0;
        while (nums[idx] == 0 && idx < nums.length) {
            idx++;
        }

        int curr = idx;
        // 非大小王的值是否存在重复
        while (curr < nums.length - 1) {
            if (nums[curr] == nums[curr + 1]) {
                return false;
            }
            curr++;
        }

        return nums[nums.length - 1] - nums[idx] < 5;
    }
}
