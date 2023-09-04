package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/11
 * @description 组合总和 II
 * <p>
 * 给定一个数组candidates和一个目标数target ，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 */
public class $40_CombinationSum2 {

    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序，便于后面去重
        Arrays.sort(candidates);
        count(0, target, candidates, 0);
        return res;
    }

    private void count(int sum, int target, int[] candidates, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> r = new ArrayList<>(tem.size());
            for (Integer integer : tem) {
                r.add(integer);
            }
            res.add(r);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 用于同一层节点的去重
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            tem.addLast(candidates[i]);
            sum += candidates[i];
            // 下一层是从第i+1个开始
            count(sum, target, candidates, i + 1);
            sum -= candidates[i];
            tem.removeLast();
        }
    }
}
