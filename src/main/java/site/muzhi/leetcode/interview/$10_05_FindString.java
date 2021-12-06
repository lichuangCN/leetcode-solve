package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/04/07
 * @description 面试题 10.05. 稀疏数组搜索
 * <p>
 * https://leetcode-cn.com/problems/sparse-array-search-lcci/
 */
public class $10_05_FindString {

    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ("".equals(words[mid]) && !words[left].equals(s)) {
                left++;
                continue;
            } else if (s.equals(words[left])) {
                return left;
            }

            if (s.equals(words[mid])) {
                return mid;
            }

            if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
