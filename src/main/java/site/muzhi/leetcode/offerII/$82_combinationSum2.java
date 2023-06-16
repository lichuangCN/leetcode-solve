package site.muzhi.leetcode.offerII;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/06/16
 * 82.含有重复元素集合的组合
 */
public class $82_combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 需要排序，为后面过滤重复元素准备
        Arrays.sort(candidates);
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
            // 过滤重复结果
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            curr.add(candidates[i]);
            travel(ans, curr, currSum + candidates[i], candidates, i + 1, target);
            curr.removeLast();
        }
    }
}
