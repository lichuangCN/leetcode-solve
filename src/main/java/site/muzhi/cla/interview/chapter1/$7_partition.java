package site.muzhi.cla.interview.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 分割回文串
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaxi62/
 */
public class $7_partition {

    public List<List<String>> partition(String s) {
        if (s == null || "".equals(s)) {
            return new ArrayList<>(0);
        }
        List<List<String>> res = new ArrayList<>();
        track(s.toCharArray(), res, new ArrayList<>(), 0);
        return res;
    }

    private void track(char[] arr, List<List<String>> res, List<String> path, int start) {
        if (start == arr.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < arr.length; i++) {
            if (isPalindrome(arr, start, i)) {
                path.add(new String(arr, start, i - start + 1));
                track(arr, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
