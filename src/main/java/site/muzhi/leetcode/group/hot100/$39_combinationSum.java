package site.muzhi.leetcode.group.hot100;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/08/24
 * 39.组合总数
 */
public class $39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        travel(ans, new ArrayDeque<>(), 0, 0, candidates, target);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int idx, int currSum, int[] candidates, int target) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // 重复解
            if (i > 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            curr.addLast(candidates[i]);
            travel(ans, curr, i, currSum + candidates[i], candidates, target);
            curr.removeLast();
        }
    }
}
