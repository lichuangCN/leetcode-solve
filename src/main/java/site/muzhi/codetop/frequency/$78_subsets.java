package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/24
 * 78.子集
 */
public class $78_subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(nums.length), nums, 0);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int[] nums, int idx) {
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            curr.addLast(nums[i]);
            travel(ans, curr, nums, i + 1);
            curr.removeLast();
        }
    }
}
