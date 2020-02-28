package site.muzhi.string;

import java.util.HashMap;

/**
 * Author: lichuang
 * Date: Create in 17:44 2019/11/14
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思路：采用滑动窗口的策略
 * 对字符串进行一次遍历,当向右移动出现重复字符时，
 * 计算左右指针的差值为寻找的长度，
 * 左指针位置更新到左侧重复字符的下一位，以当前位为第一位重新计算长度
 * 注：记录重复元素时，采用了map
 */

public class $3_LongestSubstringWithoutRepeatingCharacters {

    /**
     * 时间复杂度O(n*n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 左下标,右下标
        int left = 0, right = 0, len = 0;

        while (right < chars.length) {
            // 右指针小于字符串长度,且元素不重复
            while (right < chars.length && !hashMap.containsKey(chars[right])) {
                hashMap.put(chars[right], right);
                // 指针右移
                right++;
            }

            // 长度
            len = Math.max(len, right - left);
            // 处理完重复后,左指针指向的位置
            int temp = 0;
            if (right < chars.length) {
                // 右指针未到字符串结束
                temp = hashMap.get(chars[right]) + 1;
            } else {
                // 右指针已经到字符串结束
                temp = hashMap.get(chars[right - 1]) + 1;
            }

            // 移除重复元素
            for (int j = left; j < temp; j++) {
                hashMap.remove(chars[j]);
            }
            //
            left = temp;
        }
        return len;
    }
}
