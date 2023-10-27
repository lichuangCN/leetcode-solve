package site.muzhi.leetcode.group.tencent50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/10/23
 * 15.三数之和
 */
public class $15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            int n1 = nums[i];
            if (n1 > 0) {
                break;
            }
            if (i > 0 && n1 == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = len - 1;
            while (left < right) {
                int n2 = nums[left], n3 = nums[right];
                int sum = n1 + n2 + n3;
                if (sum == 0) {
                    ans.add(Arrays.asList(n1, n2, n3));
                    while (left < right && nums[left] == n2) left++;
                    while (left < right && nums[right] == n3) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
