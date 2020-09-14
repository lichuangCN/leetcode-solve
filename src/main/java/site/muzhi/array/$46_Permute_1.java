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
 */
public class $46_Permute_1 {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        search(0, nums, used);
        return res;
    }

    private void search(int index, int[] nums, boolean[] used) {
        if (index == nums.length) {
            List<Integer> r = new ArrayList<>(tem.size());
            for (int i : tem) {
                r.add(i);
            }
            res.add(r);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            tem.addLast(nums[i]);
            used[i] = true;
            search(index + 1, nums, used);
            tem.removeLast();
            used[i] = false;
        }
    }
}
