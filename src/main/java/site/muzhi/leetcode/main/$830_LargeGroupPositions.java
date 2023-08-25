package site.muzhi.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/01/05
 * @description 较大分组的位置
 */
public class $830_LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || "".equals(s)) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = s.length();
        for (int i = 0, j = 0; j <= len; j++) {
            if (j == len || s.charAt(i) != s.charAt(j)) {
                if (j - i >= 3) {
                    res.add(Arrays.asList(i, j - 1));
                }
                i = j;
            }
        }
        return res;
    }
}
