package site.muzhi.leetcode.group.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_07_Permutation {

    public String[] permutation(String S) {
        if (S == null || "".equals(S)) {
            return new String[0];
        }
        char[] array = S.toCharArray();

        boolean[] used = new boolean[S.length()];
        List<String> res = new ArrayList<>();
        backtrack(array.length, array, res, new ArrayList<Character>(), used);

        String[] r = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    private void backtrack(int len, char[] array, List<String> res, List<Character> t, boolean[] used) {
        if (t.size() == len) {
            StringBuilder builder = new StringBuilder();
            for (Character c : t) {
                builder.append(c);
            }
            res.add(builder.toString());
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                t.add(array[i]);
                used[i] = true;
                backtrack(len, array, res, t, used);
                t.remove(t.size() - 1);
                used[i] = false;
            }
        }
    }
}
