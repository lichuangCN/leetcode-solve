package site.muzhi.leetcode.hot100;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/08/21
 * 17.电话号码的字母组合
 */
public class $17_letterCombinations {

    // 1        2(abc)  3(def)
    // 4(ghi)   5(jkl)  6(mno)
    // 7(pqrs)  8(tuv)  9(wxyz)

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return ans;
        }
        char[] chars = digits.toCharArray();
        Map<Character, List<Character>> dict = digitMap();
        travel(ans, "", 0, dict, chars);
        return ans;
    }

    private void travel(List<String> ans, String curr, int idx, Map<Character, List<Character>> dict, char[] chars) {
        if (idx == chars.length) {
            ans.add(curr);
            return;
        }
        List<Character> list = dict.get(chars[idx]);
        for (int i = 0; i < list.size(); i++) {
            Character c = list.get(i);
            travel(ans, curr + c, idx + 1, dict, chars);
        }
    }

    public Map<Character, List<Character>> digitMap() {
        Map<Character, List<Character>> dict = new HashMap<>();
        dict.put('1', new ArrayList<>(0));
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        return dict;
    }
}
