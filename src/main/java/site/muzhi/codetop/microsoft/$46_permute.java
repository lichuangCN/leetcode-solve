package site.muzhi.codetop.microsoft;

import java.util.*;

/**
 * @author lichuang
 * @date 2022/12/04
 * @description 46. 全排列
 */
public class $46_permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        boolean[] used = new boolean[nums.length];
        travel(nums, used, 0, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void travel(int[] nums, boolean[] used, int idx, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            travel(nums, used, idx + 1, path, ans);
            path.removeLast();
            used[i] = false;
        }
    }
}
