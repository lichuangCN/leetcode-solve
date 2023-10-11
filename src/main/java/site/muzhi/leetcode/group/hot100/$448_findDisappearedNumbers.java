package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/10/11
 * 448.找到所有数组中消失的数字
 */
public class $448_findDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] t = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            t[nums[i] - 1] = nums[i];
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i] - 1 != i) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
