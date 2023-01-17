package site.muzhi.codetop.microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/01/17
 * 78 子集
 */
public class $78_subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        $78_subsets demo = new $78_subsets();
        List<List<Integer>> list = demo.subsets(nums);
        for (List<Integer> row : list) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> ans = new ArrayList<>();

        travel(ans, new ArrayDeque<>(), nums, 0);
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
