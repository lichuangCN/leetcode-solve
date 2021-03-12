package site.muzhi.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/08
 * @description
 */
public class $131_Partition {

    List<List<String>> res;
    List<String> path;
    int len;
    char[] arr;

    public List<List<String>> partition(String s) {

        res = new ArrayList<>();
        path = new ArrayList<>();
        len = s.length();
        arr = s.toCharArray();
        track(0);
        return res;
    }

    private void track(int index) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (isPalindrome(index, i)) {
                path.add(new String(arr, index, i - index + 1));
                track(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
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
