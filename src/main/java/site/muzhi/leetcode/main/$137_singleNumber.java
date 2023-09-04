package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/04/30
 * @description 只出现一次的数字 II
 * <p>
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class $137_singleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.getOrDefault(num, 0);
            val++;
            if (val == 3) {
                map.remove(num);
            } else {
                map.put(num, val);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = entry.getKey();
        }
        return res;
    }
}
