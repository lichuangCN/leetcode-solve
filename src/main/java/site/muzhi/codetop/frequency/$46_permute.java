package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/13
 * 46.全排列
 */
public class $46_permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        travel(nums, used, ans, new ArrayDeque<>());
        return ans;
    }

    private void travel(int[] nums, boolean[] used, List<List<Integer>> ans, Deque<Integer> curr) {
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
            travel(nums, used, ans, curr);
            curr.removeLast();
            used[i] = false;
        }
    }
}
