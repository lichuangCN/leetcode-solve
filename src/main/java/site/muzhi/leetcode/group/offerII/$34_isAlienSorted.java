package site.muzhi.leetcode.group.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/04/14
 * 34.外星语言是否排序
 */
public class $34_isAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null || "".equals(order)) {
            return false;
        }

        Map<Character, Integer> orderSort = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderSort.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // 比较两个词的顺序
            int w1_len = w1.length();
            int w2_len = w2.length();
            for (int j = 0; j < Math.max(w1_len, w2_len); j++) {
                int w1_order = j > w1_len - 1 ? -1 : orderSort.get(w1.charAt(j));
                int w2_order = j > w2_len - 1 ? -1 : orderSort.get(w2.charAt(j));
                // w1_order根据字典应该在w2_order后面
                if (w1_order > w2_order) return false;
                // 满足要求 不再需要继续比较
                if (w1_order < w2_order) break;
                // 如果相同 继续比较下一个字符
            }
        }
        return true;
    }
}
