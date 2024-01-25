package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2024/01/25
 * 40.组合总和 II
 */
public class $40_combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        travel(ans, new ArrayDeque<>(), candidates, 0, 0, target);
        return ans;
    }

    private void travel(List<List<Integer>> ans, ArrayDeque<Integer> curr, int[] candidates, int idx, int currSum, int target) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            curr.addLast(candidates[i]);
            travel(ans, curr, candidates, i + 1, currSum + candidates[i], target);
            curr.removeLast();
        }
    }
}
