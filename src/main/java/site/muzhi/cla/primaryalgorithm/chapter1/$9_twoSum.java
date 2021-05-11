package site.muzhi.cla.primaryalgorithm.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 两数之和
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 */
public class $9_twoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                res[0] = map.get(num);
                res[1] = i;
                break;
            }
            map.put(target - num, i);
        }
        return res;
    }

}
