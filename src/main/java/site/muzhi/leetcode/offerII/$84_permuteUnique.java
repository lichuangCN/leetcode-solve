package site.muzhi.leetcode.offerII;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/06/19
 * 84.含有重复元素集合的全排列
 */
public class $84_permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        travel(ans, new ArrayDeque<>(), nums, used);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, int[] nums, boolean[] used) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 1.当前元素已使用
            // 2.nums[i-1] == nums[i], 且used[i-1]表示已经使用相同元素得到结果
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            curr.addLast(nums[i]);
            travel(ans, curr, nums, used);
            curr.removeLast();
            used[i] = false;
        }
    }

}
