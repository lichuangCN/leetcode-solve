package site.muzhi.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: TODO
 */

public class $13_RomanToInteger {
    Map<Character, Integer> map = new HashMap();

    public void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        init();
        char[] array = s.toCharArray();
        int sum = 0, index = 0;
        int preValue = map.get(array[0]);
        for (int i = 1; i < array.length; i++) {
            int nowValue = map.get(array[i]);
            if (preValue < nowValue) {
                sum -= preValue;
            } else {
                sum += preValue;
            }
            // 指向当前字符
            preValue = nowValue;
        }
        // 加上最后一位数
        sum += preValue;
        return sum;
    }
}
