package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/01/16
 * @description URL化
 */
public class $01_03_ReplaceSpaces {

    public String replaceSpaces(String S, int length) {
        int blank = 0;
        char[] array = S.toCharArray();
        for (char c : array) {
            if (c == ' ') {
                blank++;
            }
        }

        char[] res = new char[blank * 2 + S.length()];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else {
                res[index++] = c;
            }
        }
        return String.valueOf(res, 0, index);
    }
}
