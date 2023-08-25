package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/08/18
 * 15.三数之和
 */
public class $15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            int n1 = nums[i];
            if (n1 > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == n1) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int n2 = nums[left], n3 = nums[right];
                int sum = n1 + n2 + n3;
                if (sum == 0) {
                    ans.add(Arrays.asList(n1, n2, n3));
                    // 去重
                    while (left < right && n2 == nums[left]) {
                        left++;
                    }
                    while (left < right && n3 == nums[right]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
