package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/29
 * @description 47. 全排列 II
 */
public class $47_permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        travel(nums, 0, used, new LinkedList<>(), ans);
        return ans;
    }

    private void travel(int[] nums, int idx, boolean[] used, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 避免重复排列，出现重复值
            // used[i-1]表明已经使用第i-1个元素作为开头元素匹配完毕结果，nums[i] == nums[i-1]，则不再处理nums[i]git
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            // 本轮已经使用过
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            travel(nums, idx + 1, used, path, ans);
            used[i] = false;
            path.removeLast();
        }
    }
}
