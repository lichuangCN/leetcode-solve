package site.muzhi.leetcode.group.tencent50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/10/30
 * 46.全排列
 */
public class $46_permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        travel(ans, new ArrayDeque<>(), used, nums);
        return ans;
    }

    private void travel(List<List<Integer>> ans, ArrayDeque<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curr.addLast(nums[i]);
            used[i] = true;
            travel(ans, curr, used, nums);
            used[i] = false;
            curr.removeLast();
        }
    }
}
