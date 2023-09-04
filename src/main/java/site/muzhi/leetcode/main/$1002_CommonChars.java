package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/10/14
 * @description 查找常用字符
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 你可以按任意顺序返回答案。
 */
public class $1002_CommonChars {
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>(0);
        }
        // 记录每次比较后，常用字符出现的次数,默认最大
        int[] res = new int[26];
        Arrays.fill(res,Integer.MAX_VALUE);
        for (String s : A) {
            int[] temp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                temp[s.charAt(i) - 97]++;
            }
            for (int i = 0; i < temp.length; i++) {
                res[i] = Math.min(res[i], temp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            // 相同的字符可能出现多次
            for (int j = 0; j < res[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}
