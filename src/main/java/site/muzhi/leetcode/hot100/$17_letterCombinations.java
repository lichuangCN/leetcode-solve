package site.muzhi.leetcode.hot100;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/01/18
 * 17.电话号码的字母组合
 */
public class $17_letterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> dict = new HashMap<>(8);
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> ans = new ArrayList<>();
        travel(dict, digits, 0, ans, "");
        return ans;
    }

    private void travel(Map<Character, List<Character>> dict, String digits, int idx, List<String> ans, String curr) {
        // 递归终止条件
        if (idx == digits.length()) {
            ans.add(curr);
            return;
        }
        List<Character> list = dict.get(digits.charAt(idx));
        for (int i = 0; i < list.size(); i++) {
            travel(dict, digits, idx + 1, ans, curr + list.get(i));
        }
    }
}
