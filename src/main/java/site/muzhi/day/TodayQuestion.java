package site.muzhi.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 出现已经做过的题目时，在此类中完成此题的代码的编写
 */
public class TodayQuestion {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        search(nums, 0);
        res.add(new ArrayList<>(0));
        return res;
    }

    private void search(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tem.addLast(nums[i]);
            ArrayList<Integer> r = new ArrayList<>(tem.size());
            for (Integer in : tem) {
                r.add(in);
            }
            res.add(r);
            search(nums, i + 1);
            tem.removeLast();
        }
    }
}
