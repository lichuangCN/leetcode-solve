package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2024/01/22
 * 47.全排列 II
 */
public class $47_permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        travel(ans, new ArrayDeque<>(), nums, used, 0);
        return ans;
    }

    private void travel(List<List<Integer>> ans, ArrayDeque<Integer> curr, int[] nums, boolean[] used, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            curr.addLast(nums[i]);
            used[i] = true;
            travel(ans, curr, nums, used, idx + 1);
            used[i] = false;
            curr.removeLast();
        }
    }
}
