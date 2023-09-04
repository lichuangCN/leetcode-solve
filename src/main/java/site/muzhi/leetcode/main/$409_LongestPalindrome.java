package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: lichuang
 * @date: 2020/03/19
 * @description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例:
 * 输入:"abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class $409_LongestPalindrome {

    /**
     * HashMap，低效
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        Map<Character, Integer> hashMap = new HashMap<>(52);
        // 统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        //
        int maxLength = 0;
        Set<Character> keySet = hashMap.keySet();
        for (Character c : keySet) {
            int count = hashMap.get(c);
            // 保证累加的是偶数个
            // 如果当前是偶数，则加i，如果是奇数，则只加(i-1)
            maxLength += count / 2 * 2;
            // 如果当前i是奇数，并且总长度是偶数
            // 下方代码只会执行一次
            if (((count & 1) == 1 && (maxLength & 1) == 0)) {
                maxLength++;
            }
        }
        return maxLength;
    }

    /**
     * 数组做hash表
     *
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int maxLength = 0;
        for (int i : count) {
            // 保证累加的是偶数个
            // 如果当前是偶数，则加i，如果是奇数，则只加(i-1)
            maxLength += i / 2 * 2;
            // 如果当前i是奇数，并且总长度是偶数
            // 下方代码只会执行一次
            if (((i & 1) == 1 && (maxLength & 1) == 0)) {
                maxLength++;
            }
        }
        return maxLength;
    }
}
