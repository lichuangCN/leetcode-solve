package site.muzhi.leetcode.group.tencent50;

import java.util.Arrays;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/10/23
 * 16.最接近的三数之和
 */
public class $16_threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2], len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i <= len - 3; i++) {
            int n1 = nums[i], left = i + 1, right = len - 1;
            while (left < right) {
                int sum = n1 + nums[left] + nums[right];
                ans = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                if (sum >= target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
