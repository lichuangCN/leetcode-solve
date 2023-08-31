package site.muzhi.leetcode.group.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/08/31
 * 78.子集
 */
public class $78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        travel(ans, new ArrayDeque<>(), nums, 0);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int[] nums, int idx) {
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            curr.addLast(nums[i]);
            travel(ans, curr, nums, i + 1);
            curr.removeLast();
        }
    }
}
