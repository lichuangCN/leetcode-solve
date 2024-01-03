package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/27
 * 18.四数之和
 */
public class $18_fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        int len = nums.length;
        // level 1
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // level 2
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // level 3 / 4
                int m = j + 1, n = len - 1;
                while (m < n) {
                    // 溢出 他妈的
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        // 去重
                        while (m < n && nums[n] == nums[n - 1]) n--;
                        n--;
                        while (m < n && nums[m] == nums[m + 1]) m++;
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }

        return ans;
    }
}
