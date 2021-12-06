package site.muzhi.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_04_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums.length, 0, nums, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int len, int idx, int[] nums, List<List<Integer>> res, List<Integer> t) {
        res.add(new ArrayList<Integer>(t));
        for (int i = idx; i < len; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            t.add(nums[i]);
            backtrack(len, i + 1, nums, res, t);
            t.remove(t.size() - 1);
        }
    }
}
