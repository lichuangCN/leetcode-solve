package site.muzhi.codetop.microsoft;

import java.util.*;

/**
 * @author lichuang
 * @date 2022/11/29
 * @description 39. 组合总和
 */
public class $39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(candidates, target, 0, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void travel(int[] candidates, int target, int sum, int idx, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 剪枝
        if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 跳过相同的值
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.addLast(candidates[i]);
            sum += candidates[i];
            travel(candidates, target, sum, i, path, ans);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
