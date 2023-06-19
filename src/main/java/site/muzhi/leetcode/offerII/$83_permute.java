package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/19
 * 83.没有重复元素集合的全排列
 */
public class $83_permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        travel(ans, new ArrayDeque<>(), nums, used);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int[] nums, boolean[] used) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 当前元素已经在集合中
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.addLast(nums[i]);
            travel(ans, curr, nums, used);
            curr.removeLast();
            used[i] = false;
        }
    }
}
