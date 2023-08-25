package site.muzhi.leetcode.group.interview;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2021/01/16
 * @description 判定是否互为字符重排
 */
public class $01_02_CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) && (s1 != null && s2 == null)) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = s2.toCharArray();
        Arrays.sort(array2);

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

}
