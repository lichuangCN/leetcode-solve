package site.muzhi.leetcode.cla.interview.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lichuang
 * @date 2021/05/08
 * @description 最大数
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa1401/
 */
public class $1_largestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        List<String> list = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        String res = builder.toString();
        return (res.charAt(0) == '0') ? "0" : res;
    }
}
