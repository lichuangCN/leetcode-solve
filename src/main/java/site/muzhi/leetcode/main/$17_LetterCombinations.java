package site.muzhi.leetcode.main;

import java.util.*;

/**
 * @author lichuang
 * @date 2020/08/26
 * @description 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class $17_LetterCombinations {

    private Map<Character, String[]> init() {
        Map<Character, String[]> initMap = new HashMap<>(8);
        initMap.put('2', new String[]{"a", "b", "c"});
        initMap.put('3', new String[]{"d", "e", "f"});
        initMap.put('4', new String[]{"g", "h", "i"});
        initMap.put('5', new String[]{"j", "k", "l"});
        initMap.put('6', new String[]{"m", "n", "o"});
        initMap.put('7', new String[]{"p", "q", "r", "s"});
        initMap.put('8', new String[]{"t", "u", "v"});
        initMap.put('9', new String[]{"w", "x", "y", "z"});
        return initMap;
    }

    /**
     * 递归回溯
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return res;
        }
        Map<Character, String[]> initMap = init();
        iterator(res, initMap, digits, "", 0);
        return res;
    }

    /**
     * @param res
     * @param initMap
     * @param digits
     * @param r       上层递归已经拼起来的字符串
     * @param index
     */
    private void iterator(List<String> res, Map<Character, String[]> initMap, String digits, String r, int index) {
        // 递归终止条件
        // 递归已经到达了最后一位，比如 "123",当 index = 3的时候，表示已经递归到了"3"
        if (index == digits.length()) {
            res.add(r);
            return;
        }
        // 每次向下递归的时候,会将上层已经拼接好的字符串 r 传递到下一层递归
        String[] strArr = initMap.get(digits.charAt(index));
        for (int i = 0; i < strArr.length; i++) {
            // 同时index+1表示向下一位递归
            iterator(res, initMap, digits, r + strArr[i], index + 1);
        }
    }
}
