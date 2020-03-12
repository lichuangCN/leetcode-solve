package site.muzhi.array;

import java.util.Arrays;

/**
 * @author: lichuang
 * @date: 2020/03/12
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 标签：排序和双指针
 * 1.本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n^3)O(n3)，需要降低时间复杂度
 * 2.首先进行数组排序，时间复杂度 O(nlogn)O(nlogn)
 * 3.在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
 * 4.再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
 * 5.根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
 * 6.同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
 * 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)O(n2)
 * 总时间复杂度：O(nlogn) + O(n^2) = O(n^2)O(nlogn)+O(n2)=O(n2)
 */

public class $16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // 先对数组进行排序
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 重新计算和
                int sum = nums[i] + nums[left] + nums[right];
                // 如果当前和比之前和更接近目标值
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {
                    // 当前和大于目标值，右指针左移，减小和
                    right--;
                } else if (sum < target) {
                    // 当前和小目标值，左指针右移，增大和
                    left++;
                } else {
                    // 如果当前和等于目标值，直接返回
                    return result;
                }
            }
        }
        return result;
    }
}
