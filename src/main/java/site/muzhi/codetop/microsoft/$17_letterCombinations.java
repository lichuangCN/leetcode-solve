package site.muzhi.codetop.microsoft;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/01/17
 * 17 电话号码的字母组合
 */
public class $17_letterCombinations {

    private Map<Character, List<Character>> dict;

    private void initDict() {
        dict = new HashMap<>(8);
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'o', 'n'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>(0);
        }
        initDict();

        List<String> ans = new ArrayList<>();
        travel(ans, digits, "", 0);
        return ans;
    }

    private void travel(List<String> ans, String digits, String curr, int idx) {
        if (idx == digits.length()) {
            ans.add(curr);
            return;
        }
        List<Character> code = dict.get(digits.charAt(idx));
        for (Character c : code) {
            travel(ans, digits, curr + c, idx + 1);
        }
    }
}
