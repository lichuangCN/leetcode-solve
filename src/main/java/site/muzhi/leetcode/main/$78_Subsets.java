package site.muzhi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 */
public class $78_Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * @param nums
     * @param i      从当前数组的第几个元素
     * @param result 结果集
     * @param tmp
     */
    public void backtrack(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> tmp) {
        result.add(new ArrayList<Integer>(tmp));
        for (int start = i; start < nums.length; start++) {
            tmp.add(nums[start]);
            backtrack(nums, start + 1, result, tmp);
            // 将本次添加的元素移除，避免回溯时当前元素出现重复
            tmp.remove(tmp.size() - 1);
        }
    }
}
