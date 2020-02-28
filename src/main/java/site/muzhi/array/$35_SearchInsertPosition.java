package site.muzhi.array;

/**
 * Author: lichuang
 * Date: 2020/02/06
 * <p>
 * 35. 搜索插入位置 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。 实例: 输入: [1,3,5,6], 5 输出: 2
 */
public class $35_SearchInsertPosition {

    /**
     * 二分法查找目标元素在数组中的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // int middle = (left + right) / 2;
        // 可以避免left+right超出int类型取值范围
        int middle = left + (right - left) / 2;
        while (left <= right) {
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
            middle = (left + right) / 2;
        }
        // 执行到这里说明目标数值不存在，以下判断是在当前位置或后一位插入目标数值
        if (nums[middle] > target) {
            return middle;
        } else {
            return middle + 1;
        }
    }

}
