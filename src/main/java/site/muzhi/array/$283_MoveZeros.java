package site.muzhi.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 20:46 2019/9/23
 * Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾
 * 同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */

public class $283_MoveZeros {

    /**
     * 时间复杂度o(n),空间复杂度o(1)
     *
     * @param nums
     */
    public void moveZeros(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间复杂度o(n),空间复杂度o(n)
     *
     * @param nums
     */
    public void moveZeros2(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                integers.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < integers.size()) {
                nums[i] = integers.get(i);
            } else {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
