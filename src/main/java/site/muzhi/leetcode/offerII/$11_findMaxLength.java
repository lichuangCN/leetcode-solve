package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/03/06
 * 0和1个数相同的子数组
 * 前缀和：即子数组中的元素相加 = 0
 */
public class $11_findMaxLength {

    public int findMaxLength(int[] nums) {

        int length = nums.length;
        int[] sum = new int[length + 1];
        // 前缀和区间: [1, length]
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> preMap = new HashMap<>();
        // <key, val> 前缀和 = key的最小下标 = val
        preMap.put(0, 0);
        int ans = 0;
        for (int i = 1; i <= length; i++) {
            int t = sum[i];
            if (preMap.containsKey(t - 0)) {
                ans = Math.max(ans, i - preMap.get(t - 0));
            } else {
                // 前缀和集合中，没有当前前缀和值时，添加
                preMap.put(t, i);
            }
        }
        return ans;
    }
}
