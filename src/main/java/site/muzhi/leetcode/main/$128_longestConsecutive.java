package site.muzhi.leetcode.main;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2024/01/04
 * 128.最长连续序列
 */
public class $128_longestConsecutive {


    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int ans = 0;
        for (int num : nums) {
            int curr = num;
            if (!set.contains(curr - 1)) {
                while (set.contains(curr + 1)) curr++;
            }
            ans = Math.max(ans, curr - num + 1);
        }
        return ans;
    }
}
