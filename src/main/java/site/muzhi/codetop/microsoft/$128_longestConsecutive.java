package site.muzhi.codetop.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/01/13
 * 128 最长连续序列
 */
public class $128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            int curr = num;
            // 当前num已经是存在的序列的最小值
            if (!set.contains(curr - 1)) {
                // 依次向后寻找
                while (set.contains(curr + 1)) {
                    curr++;
                }
            }
            ans = Math.max(ans, curr - num + 1);
        }
        return ans;
    }
}
