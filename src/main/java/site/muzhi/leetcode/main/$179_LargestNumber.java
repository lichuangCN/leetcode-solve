package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2021/04/12
 * @description
 */
public class $179_LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] arrs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arrs[i] = String.valueOf(nums[i]);
        }

        // 字典序排序
        Arrays.sort(arrs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder builder = new StringBuilder();
        for (String s : arrs) {
            builder.append(s);
        }
        String r = builder.toString();
        if (r.charAt(0) == '0') {
            return "0";
        }
        return r;
    }
}
