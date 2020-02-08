package site.muzhi.array;

/**
 * Author: lichuang
 * Date: Create in 21:20 2019/9/23
 * Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1)
 * 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // index 标记不重复元素的个数（下标），cursor标记遍历到的位置
        int index = 0, cursor = 1;
        while (cursor < nums.length) {
            if (nums[index] == nums[cursor]) {
                cursor++;
                continue;
            }
            if (nums[index] != nums[cursor]) {
                nums[++index] = nums[cursor];
                cursor++;
            }
        }
        return index + 1;
    }
}
