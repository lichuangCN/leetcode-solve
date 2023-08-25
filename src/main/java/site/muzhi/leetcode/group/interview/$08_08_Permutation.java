package site.muzhi.leetcode.group.interview;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_08_Permutation {


    public String[] permutation(String S) {
        if (S == null || "".equals(S)) {
            return new String[0];
        }

        Set<String> res = new HashSet<>();
        boolean[] used = new boolean[S.length()];
        char[] array = S.toCharArray();

        backtrack(array.length, array, res, new StringBuilder(), used);

        String[] r = new String[res.size()];
        int i = 0;
        for (String s : res) {
            r[i++] = s;
        }
        return r;
    }

    public void backtrack(int len, char[] array, Set<String> res, StringBuilder t, boolean[] used) {
        if (t.length() == len) {
            res.add(t.toString());
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                t.append(array[i]);
                used[i] = true;
                backtrack(len, array, res, t, used);
                used[i] = false;
                t.deleteCharAt(t.length() - 1);
            }
        }
    }
}
