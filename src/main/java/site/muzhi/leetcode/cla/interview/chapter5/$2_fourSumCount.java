package site.muzhi.leetcode.cla.interview.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/04/29
 * @description 四数相加 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xakn6r/
 */
public class $2_fourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int sumAB = i + j;
                Integer val = map.getOrDefault(sumAB, 0);
                map.put(sumAB, val + 1);
            }
        }

        int res = 0;

        for (int k : nums3) {
            for (int l : nums4) {
                int sum = (k + l) * -1;
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }

        return res;
    }
}
