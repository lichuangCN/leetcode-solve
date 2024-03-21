package site.muzhi.codetop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2024/03/21
 * 15. 三数之和
 */
public class $15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int n1 = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int n2 = nums[left], n3 = nums[right];
                int sum = n1 + n2 + n3;
                if (sum == 0) {
                    ans.add(Arrays.asList(n1, n2, n3));
                    while (left < right && nums[left] == n2) {
                        left++;
                    }
                    while (left < right && nums[right] == n3) {
                        right--;
                    }
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
