package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/11
 * 15.三数之和
 */
public class $15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int n1 = nums[i];
            // 第一个元素>0, 表明后续已经不可能有值满足 n1+n2+n3=0
            if (n1 > 0) {
                break;
            }

            // 过滤重复解
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // 遍历后半截
            int left = i + 1, right = len - 1;
            while (left < right) {
                int n2 = nums[left], n3 = nums[right];
                int sum = n1 + n2 + n3;
                if (sum == 0) {
                    ans.add(Arrays.asList(n1, n2, n3));
                    // 过滤重复解
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
