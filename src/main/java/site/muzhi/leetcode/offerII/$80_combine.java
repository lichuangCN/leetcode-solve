package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/16
 * 77.含K个元素的组合
 */
public class $80_combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), n, 1, k);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int n, int idx, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i <= n; i++) {
            curr.add(i);
            travel(ans, curr, n, i + 1, k);
            curr.removeLast();
        }
    }
}
