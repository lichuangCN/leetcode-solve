package site.muzhi.codetop.frequency;

import java.util.*;

/**
 * @auth lichuang
 * @data 2023/07/31
 * 39.组合总和
 */
public class $39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        travel(ans, new ArrayDeque<>(), 0, 0, candidates, target);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int currSum, int idx, int[] candidates, int target) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            curr.addLast(candidates[i]);
            travel(ans, curr, currSum + candidates[i], i, candidates, target);
            curr.removeLast();
        }
    }
}
