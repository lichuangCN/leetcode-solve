package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/16
 * 81.允许重复选择元素的组合
 */
public class $81_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), 0, candidates, 0, target);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int currSum, int[] candidates, int idx, int target) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            curr.add(candidates[i]);
            travel(ans, curr, currSum + candidates[i], candidates, i, target);
            curr.removeLast();
        }
    }

}
