package site.muzhi.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/14
 * @description 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 交换
 */
public class $46_Permute_2 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        search(0, nums);
        return res;
    }

    private void search(int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> r = new ArrayList<>(nums.length);
            for (int i : nums) {
                r.add(i);
            }
            res.add(r);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            search(index + 1, nums);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int num = nums[x];
        nums[x] = nums[y];
        nums[y] = num;
    }
}
