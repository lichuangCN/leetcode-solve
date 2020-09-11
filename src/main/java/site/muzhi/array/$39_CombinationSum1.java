package site.muzhi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/11
 * @description 组合总数
 * <p>
 * 给定一个无重复元素的数组candidates和一个目标数target
 * 找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 */
public class $39_CombinationSum1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        search(0, target, candidates, 0);
        return res;
    }

    private void search(int sum, int target, int[] condidates, int index) {
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
        for (int i = index; i < condidates.length; i++) {
            if (i > index && condidates[i - 1] == condidates[i]) {
                continue;
            }
            tem.addLast(condidates[i]);
            sum += condidates[i];
            // 因为每个节点可以重复使用，下一层仍旧是从第i个开始
            search(sum, target, condidates, i);
            sum -= condidates[i];
            tem.removeLast();
        }
    }
}
