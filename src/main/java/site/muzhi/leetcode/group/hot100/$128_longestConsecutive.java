package site.muzhi.leetcode.group.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/09/05
 * 128.最长连续序列
 */
public class $128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 1;
        for (Integer n : set) {
            int curr = n;
            // curr 片段的第一个元素
            if (!set.contains(curr - 1)) {
                while (set.contains(curr + 1)) {
                    curr++;
                }
            }
            ans = Math.max(ans, curr - n + 1);
        }
        return ans;
    }
}
