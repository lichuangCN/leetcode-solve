package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/19
 * 15.三数之和
 */
public class $15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 排序后的第一个元素 > 0，必然不会有和等于0的元素
            if (nums[i] > 0) {
                break;
            }
            // 排完序后，如果当前值nums[i]和前一个值nums[i-1]相同，则后续出现和 = 0的元素，也是和 nums[i-1]的结果重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 过滤存在的重复结果
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 查询下一个有效值
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // 暴力解决方法
        //for (int i = 0; i < len; i++) {
        //    for (int j = i; j < len; j++) {
        //        for (int k = j; k < len; k++) {
        //            int sum = nums[i] + nums[j] + nums[k];
        //            if (sum == 0) {
        //                ans.add(Arrays.asList(nums[i], nums[k], nums[k]));
        //            }
        //        }
        //    }
        //}

        return ans;
    }
}
