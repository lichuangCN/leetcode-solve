package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/18
 * @description 全排列
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class $47_PermuteUnique {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        search(nums, used, 0);
        return res;
    }

    private void search(int[] nums, boolean[] used, int index) {
        if (index == nums.length) {
            ArrayList<Integer> r = new ArrayList<>(index);
            for (Integer i : tem) {
                r.add(i);
            }
            res.add(r);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 从左向右第一个未使用的数字
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            tem.addLast(nums[i]);
            used[i] = true;
            search(nums, used, index + 1);
            used[i] = false;
            tem.removeLast();
        }
    }
}
