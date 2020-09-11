package site.muzhi.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/11
 * @description 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1-9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 */
public class $216_CombinationSum3 {

    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 从1开始计数
        count(0, n, k, 1);
        return res;
    }

    public void count(int sum, int n, int k, int index) {
        // 剪枝操作
        if (tem.size() > k || sum > n) {
            return;
        }
        // 满足条件
        if (tem.size() == k && sum == n) {
            List<Integer> r = new ArrayList<>(k);
            for (Integer integer : tem) {
                r.add(integer);
            }
            res.add(r);
            return;
        }

        for (int i = index; i <= 9; i++) {
            sum += i;
            tem.addLast(i);
            count(sum, n, k, i + 1);
            tem.removeLast();
            sum -= i;
        }
    }
}
