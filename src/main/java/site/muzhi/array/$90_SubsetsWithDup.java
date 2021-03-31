package site.muzhi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $90_SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums.length, 0, nums, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int len, int index, int[] nums, List<List<Integer>> res, List<Integer> t) {
        res.add(new ArrayList<>(t));
        for (int i = index; i < len; i++) {
            // 去重
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            t.add(nums[i]);
            backtrack(len, i + 1, nums, res, t);
            t.remove(t.size() - 1);
        }
    }
}
