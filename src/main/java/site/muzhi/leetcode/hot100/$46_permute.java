package site.muzhi.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/08/24
 * 46.全排列
 */
public class $46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        travel(ans, new ArrayDeque<>(), used, nums);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.addLast(nums[i]);
            travel(ans, curr, used, nums);
            curr.removeLast();
            used[i] = false;
        }
    }
}
