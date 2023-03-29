package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/03/29
 * 不含重复字符的最长子字符串
 */
public class $16_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] array = s.toCharArray();
        int ans = 0, len = array.length, left = 0;
        Map<Character, Integer> charIdx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char curr = array[i];
            if (!charIdx.containsKey(curr)) {
                // 加入窗口
                charIdx.put(curr, i);
                continue;
            }
            ans = Math.max(ans, i - left);
            // 移除窗口中重复元素及左侧元素
            int repeatIdx = charIdx.get(curr);
            while (left <= repeatIdx) {
                charIdx.remove(array[left++]);
            }
            // 重复元素加入窗口
            charIdx.put(curr, i);
            // left指向窗口最左侧元素
        }
        // 计算最后一个窗口
        ans = Math.max(ans, len - left);
        return ans;
    }
}
