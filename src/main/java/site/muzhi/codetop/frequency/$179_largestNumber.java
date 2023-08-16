package site.muzhi.codetop.frequency;


import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/08/16
 * 179.最大数
 */
public class $179_largestNumber {


    public String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 字典排序：根据 x+y 和 y+x 拼接后的字符串进行字典排序 降序
        Arrays.sort(strs, (x, y) -> {
            String s1 = x + y, s2 = y + x;
            return s2.compareTo(s1);
        });
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        String ans = builder.toString();

        return ans.charAt(0) == '0' ? "0" : ans;
    }
}
