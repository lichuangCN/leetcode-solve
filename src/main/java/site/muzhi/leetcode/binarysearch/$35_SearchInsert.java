package site.muzhi.leetcode.binarysearch;

/**
 * @author lichuang
 * @date 2021/12/09
 * @description 35. 搜索插入位置
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class $35_SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }

        // 未找到target值
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] > target) {
            return 0;
        }
        if (target < nums[mid]) {
            return mid;
        } else {
            return mid + 1;
        }
    }

    /**
     * 二分法查找目标元素在数组中的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert_2(int[] nums, int target) {
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
            // 此处不使用注释的mid计算方式，是在下面判断中会出现数组索引溢出的情况，处理方式可参考上面的方法
            // mid = left + (right - left) / 2;
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
