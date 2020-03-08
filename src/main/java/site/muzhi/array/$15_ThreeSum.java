package site.muzhi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */

public class $15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        // 将给定的数组排序（递增）
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 如果当前数字大于0，则和之后的两个数相加不可能等于0
            if (nums[i] > 0) {
                break;
            }
            // 定义两个指针，分别指向后续元素的头和尾
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 同时向中间移动
                    left++;
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}
